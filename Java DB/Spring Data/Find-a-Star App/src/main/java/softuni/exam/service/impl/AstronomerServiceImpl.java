package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.config.XmlParser;
import softuni.exam.models.dto.AstronomerDTO;
import softuni.exam.models.dto.AstronomersRootDTO;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtilsImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

// TODO: Implement all methods
@Service
public class AstronomerServiceImpl implements AstronomerService {
    private static String ASTRONOMER_FILE_PATH = "src/main/resources/files/xml/astronomers.xml";
    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository,
                                 StarRepository starRepository,
                                 XmlParser xmlParser,
                                 ModelMapper modelMapper,
                                 ValidationUtilsImpl validationUtils) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(ASTRONOMER_FILE_PATH));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<AstronomerDTO> astronomers = xmlParser
                .fromFile(Path.of(ASTRONOMER_FILE_PATH).toFile(), AstronomersRootDTO.class)
                .getAstronomers();

        for (AstronomerDTO a : astronomers) {
            Optional<Astronomer> astronomerExist = this.astronomerRepository
                    .findByFirstNameAndLastName(a.getFirstName(), a.getLastName());
            Optional<Star> starExist = this.starRepository
                    .findById(a.getObservingStarId().longValue());

            if (astronomerExist.isPresent() || starExist.isEmpty() || !validationUtils.isValid(a)) {
                sb.append("Invalid astronomer");
                sb.append(System.lineSeparator());

                continue;
            }

            Astronomer astronomerToSave = modelMapper.map(a, Astronomer.class);
            astronomerToSave.setObservingStar(starExist.get());
            this.astronomerRepository.save(astronomerToSave);
            sb.append(String.format("Successfully imported astronomer %s %s - %.2f%n",
                    astronomerToSave.getFirstName(),
                    astronomerToSave.getLastName(),
                    astronomerToSave.getAverageObservationHours()));
        }

        return sb.toString().trim();
    }
}
