package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentDTO;
import softuni.exam.models.dto.ApartmentRootDTO;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtilsImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private static String APARTMENT_FILE_PATH = "src/main/resources/files/xml/apartments.xml";
    private final ApartmentRepository apartmentRepository;
    private final TownRepository townRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository,
                                TownRepository townRepository,
                                XmlParser xmlParser,
                                ModelMapper modelMapper,
                                ValidationUtilsImpl validationUtils) {
        this.apartmentRepository = apartmentRepository;
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENT_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<ApartmentDTO> apartments = xmlParser.fromFile(Path.of(APARTMENT_FILE_PATH).toFile(), ApartmentRootDTO.class)
                .getApartments().stream().toList();

        for (ApartmentDTO a : apartments) {
            Town town = this.townRepository.findByTownName(a.getTown()).get();

            Optional<Apartment> exist = this.apartmentRepository.findByTownAndArea(town, a.getArea());

            if (exist.isPresent() || !validationUtils.isValid(a)) {
                sb.append("Invalid apartment");
                sb.append(System.lineSeparator());

                continue;
            }

            Apartment apartmentToSave = modelMapper.map(a, Apartment.class);
            apartmentToSave.setTown(town);
            this.apartmentRepository.save(apartmentToSave);
            sb.append(String.format("Successfully imported apartment %s - %.2f%n",
                    apartmentToSave.getApartmentType(), apartmentToSave.getArea()));
        }

        return sb.toString().trim();
    }
}
