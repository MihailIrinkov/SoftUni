package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TicketDTO;
import softuni.exam.models.dto.TicketRootDTO;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.ValidationUtilsImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    private static String TICKET_FILE_PATH = "src/main/resources/files/xml/tickets.xml";
    private final TicketRepository ticketRepository;
    private final TownRepository townRepository;
    private final PassengerRepository passengerRepository;
    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public TicketServiceImpl(TicketRepository ticketRepository,
                             TownRepository townRepository,
                             PassengerRepository passengerRepository,
                             PlaneRepository planeRepository,
                             XmlParser xmlParser,
                             ModelMapper modelMapper,
                             ValidationUtilsImpl validationUtils) {
        this.ticketRepository = ticketRepository;
        this.townRepository = townRepository;
        this.passengerRepository = passengerRepository;
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return Files.readString(Path.of(TICKET_FILE_PATH));
    }

    @Override
    public String importTickets() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        List<TicketDTO> tickets = xmlParser.fromFile(Path.of(TICKET_FILE_PATH).toFile(), TicketRootDTO.class)
                .getTickets().stream().collect(Collectors.toList());

        for (TicketDTO t : tickets) {
            Optional<Ticket> ticketExists = this.ticketRepository.findBySerialNumber(t.getSerialNumber());
            Optional<Town> toTown = this.townRepository.findAllByName(t.getToTown().getName());
            Optional<Town> fromTown = this.townRepository.findAllByName(t.getFromTown().getName());
            Optional<Passenger> passengerExists =
                    this.passengerRepository.findAllByEmail(t.getPassenger().getEmail());
            Optional<Plane> planeExists =
                    this.planeRepository.findAllByRegisterNumber(t.getPlane().getRegisterNumber());

            if (ticketExists.isPresent() || toTown.isEmpty() || fromTown.isEmpty()
                    || passengerExists.isEmpty() || planeExists.isEmpty() || !validationUtils.isValid(t)) {
                sb.append("Invalid Ticket");
                sb.append(System.lineSeparator());

                continue;
            }

            Ticket ticketToSave = modelMapper.map(t, Ticket.class);
            ticketToSave.setFromTown(this.townRepository.findAllByName(t.getFromTown().getName()).get());
            ticketToSave.setToTown(this.townRepository.findAllByName(t.getToTown().getName()).get());
            ticketToSave.setPassenger(this.passengerRepository.findAllByEmail(t.getPassenger().getEmail()).get());
            ticketToSave.setPlane(this.planeRepository.findAllByRegisterNumber(t.getPlane().getRegisterNumber()).get());
            this.ticketRepository.save(ticketToSave);

            sb.append(String.format("Successfully imported Ticket %s - %s%n",
                    ticketToSave.getFromTown().getName(), ticketToSave.getToTown().getName()));
        }


        return sb.toString().trim();
    }
}
