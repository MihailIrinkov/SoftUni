package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferDTO;
import softuni.exam.models.dto.OfferRootDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.ApartmentType;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtilsImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private static String OFFER_FILE_PATH = "src/main/resources/files/xml/offers.xml";
    private final OfferRepository offerRepository;
    private final AgentRepository agentRepository;
    private final ApartmentRepository apartmentRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;
    private final XmlParser xmlParser;

    public OfferServiceImpl(OfferRepository offerRepository,
                            AgentRepository agentRepository,
                            ApartmentRepository apartmentRepository,
                            ModelMapper modelMapper,
                            ValidationUtilsImpl validationUtils,
                            XmlParser xmlParser) {
        this.offerRepository = offerRepository;
        this.agentRepository = agentRepository;
        this.apartmentRepository = apartmentRepository;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFER_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<OfferDTO> offers = xmlParser.fromFile(Path.of(OFFER_FILE_PATH).toFile(), OfferRootDTO.class)
                .getOffers().stream().toList();

        for (OfferDTO o : offers) {
            Optional<Agent> agent = this.agentRepository.findByFirstName(o.getAgent().getName());

            if (agent.isEmpty() || !validationUtils.isValid(o)) {
                sb.append("Invalid offer");
                sb.append(System.lineSeparator());

                continue;
            }

            Offer offerToSave = modelMapper.map(o, Offer.class);
            offerToSave.setAgent(agent.get());
            offerToSave.setApartment(this.apartmentRepository.getById(o.getApartment().getId()));

            this.offerRepository.save(offerToSave);
            sb.append(String.format("Successfully imported offer %.2f%n", offerToSave.getPrice()));
        }

        return sb.toString().trim();
    }

    @Override
    public String exportOffers() {
        StringBuilder sb = new StringBuilder();

        List<Offer> apartments =this.offerRepository
        .findAllBy(ApartmentType.three_rooms);


        for (Offer o : apartments) {
            sb.append(String.format("Agent %s %s with offer №%d:%n",
                    o.getAgent().getFirstName(), o.getAgent().getLastName(), o.getId()));
            sb.append(String.format("\t-Apartment area: %.2f%n", o.getApartment().getArea()));
            sb.append(String.format("\t--Town: %s%n", o.getApartment().getTown()));
            sb.append(String.format("\t---Price: %s$%n", o.getPrice().setScale(2)));
        }

        return sb.toString().trim();
    }
}
