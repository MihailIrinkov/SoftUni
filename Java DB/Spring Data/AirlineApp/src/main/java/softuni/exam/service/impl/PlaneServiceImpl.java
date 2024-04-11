package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PlaneDTO;
import softuni.exam.models.dto.PlaneRootDTO;
import softuni.exam.models.entities.Plane;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.service.PlaneService;
import softuni.exam.util.ValidationUtilsImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlaneServiceImpl implements PlaneService {

    private static String PLANE_FILE_PATH = "src/main/resources/files/xml/planes.xml";
    private final PlaneRepository planeRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public PlaneServiceImpl(PlaneRepository planeRepository,
                            XmlParser xmlParser,
                            ModelMapper modelMapper,
                            ValidationUtilsImpl validationUtils) {
        this.planeRepository = planeRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.planeRepository.count() > 0;
    }

    @Override
    public String readPlanesFileContent() throws IOException {
        return Files.readString(Path.of(PLANE_FILE_PATH));
    }

    @Override
    public String importPlanes() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        List<PlaneDTO> planes = xmlParser.fromFile(Path.of(PLANE_FILE_PATH).toFile(), PlaneRootDTO.class)
                .getPlanes();

        for (PlaneDTO p : planes) {
            Optional<Plane> exists =
                    this.planeRepository.findAllByRegisterNumber(p.getRegisterNumber());
            if (exists.isPresent() || !validationUtils.isValid(p)) {
                sb.append("Invalid Plane");
                sb.append(System.lineSeparator());

                continue;
            }

            Plane planeToSave = modelMapper.map(p, Plane.class);
            this.planeRepository.save(planeToSave);
            sb.append(String.format("Successfully imported Plane %s%n",
                    planeToSave.getRegisterNumber()));
        }

        return sb.toString().trim();
    }
}
