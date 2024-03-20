package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationDTO;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// TODO: Implement all methods
@Service
public class ConstellationServiceImpl implements ConstellationService {

    private static String CONSTELLATION_FILE_PATH =
            "src/main/resources/files/json/constellations.json";

    private final ConstellationRepository constellationRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, Gson gson, ModelMapper modelMapper, ValidationUtilsImpl validationUtils) {
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(CONSTELLATION_FILE_PATH));
    }

    @Override
    public String importConstellations() throws IOException {

        StringBuilder sb = new StringBuilder();

        List<ConstellationDTO> constelationsList =
                Arrays.stream(gson.fromJson(readConstellationsFromFile(), ConstellationDTO[].class))
                        .collect(Collectors.toList());

        for (ConstellationDTO c : constelationsList) {
            Optional<Constellation> constellationExist =
                    this.constellationRepository.findAllByName(c.getName());

            if (constellationExist.isPresent() || !validationUtils.isValid(c)) {
                sb.append("Invalid constellation");
                sb.append(System.lineSeparator());

                continue;
            }

            Constellation constellationToSave = modelMapper.map(c, Constellation.class);
            this.constellationRepository.save(constellationToSave);
            sb.append(String.format("Successfully imported constellation %s - %s%n",
                    constellationToSave.getName(), constellationToSave.getDescription()));
        }

        return sb.toString().trim();
    }
}
