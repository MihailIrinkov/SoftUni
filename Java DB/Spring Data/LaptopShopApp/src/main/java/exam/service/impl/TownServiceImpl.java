package exam.service.impl;

import exam.model.dto.TownDTO;
import exam.model.dto.TownRootDTO;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtilsImpl;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService {

    private static String TOWN_FILE_PATH = "src/main/resources/files/xml/towns.xml";
    private final TownRepository townRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public TownServiceImpl(TownRepository townRepository,
                           XmlParser xmlParser,
                           ModelMapper modelMapper,
                           ValidationUtilsImpl validationUtils) {
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        List<TownDTO> towns = xmlParser.fromFile(Path.of(TOWN_FILE_PATH).toFile(), TownRootDTO.class)
                .getTowns().stream().toList();

        for (TownDTO t : towns) {
            Optional<Town> exist = this.townRepository.findByName(t.getName());
            if (exist.isPresent() || !validationUtils.isValid(t)) {
                sb.append("Invalid town");
                sb.append(System.lineSeparator());

                continue;
            }

            Town townToSave = modelMapper.map(t, Town.class);
            this.townRepository.save(townToSave);
            sb.append(String.format("Successfully imported Town %s%n", townToSave.getName()));
        }

        return sb.toString().trim();
    }
}
