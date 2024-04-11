package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PassengerDTO;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Ticket;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.PassengerService;
import softuni.exam.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {

    private static String PASSENGER_FILE_PATH = "src/main/resources/files/json/passengers.json";
    private final PassengerRepository passengerRepository;
    private final TownRepository townRepository;
    private final TicketRepository ticketRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public PassengerServiceImpl(PassengerRepository passengerRepository,
                                TownRepository townRepository,
                                TicketRepository ticketRepository,
                                Gson gson,
                                ModelMapper modelMapper,
                                ValidationUtilsImpl validationUtils) {
        this.passengerRepository = passengerRepository;
        this.townRepository = townRepository;
        this.ticketRepository = ticketRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.passengerRepository.count() > 0;
    }

    @Override
    public String readPassengersFileContent() throws IOException {
        return Files.readString(Path.of(PASSENGER_FILE_PATH));
    }

    @Override
    public String importPassengers() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<PassengerDTO> passengers = Arrays.stream(gson.fromJson(readPassengersFileContent(), PassengerDTO[].class))
                .collect(Collectors.toList());

        for (PassengerDTO p : passengers) {
            Optional<Passenger> exists = this.passengerRepository.findAllByEmail(p.getEmail());
            if (exists.isPresent() || !validationUtils.isValid(p)) {
                sb.append("Invalid Passenger");
                sb.append(System.lineSeparator());

                continue;
            }

            Passenger passengerToSave = modelMapper.map(p, Passenger.class);
            passengerToSave.setTown(this.townRepository.findAllByName(p.getTown()).get());
            this.passengerRepository.save(passengerToSave);
            sb.append(String.format("Successfully imported Passenger %s - %s%n",
                    passengerToSave.getLastName(), passengerToSave.getEmail()));
        }

        return sb.toString().trim();
    }

    @Override
    public String getPassengersOrderByTicketsCountDescendingThenByEmail() {
        StringBuilder sb = new StringBuilder();

        List<Long> byTicketCount = this.ticketRepository.findByTicketCount();

        List<Passenger> passengers = this.passengerRepository.findAll();
        for (Long id : byTicketCount) {
            for (Passenger p : passengers) {
                if (p.getId().equals(id)) {
                    List<Ticket> byPassengerId = this.ticketRepository.findAllByPassengerId(id);
                    Passenger byId = this.passengerRepository.findById(id).get();
                    sb.append(String.format("Passenger %s  %s\n" +
                                    "\tEmail - %s\n" +
                                    "\tPhone - %s\n" +
                                    "\tNumber of tickets - %d\n",
                            p.getFirstName(),
                            byId.getLastName(),
                            byId.getEmail(),
                            byId.getPhoneNumber(),
                            byPassengerId.size()));

                }
            }
        }


        return sb.toString().trim();
    }
}
