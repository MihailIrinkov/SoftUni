package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.StarDTO;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

// TODO: Implement all methods
@Service
public class StarServiceImpl implements StarService {

    private static String STAR_FILE_PATH = "src/main/resources/files/json/stars.json";
    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;
    private final AstronomerRepository astronomerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public StarServiceImpl(StarRepository starRepository,
                           ConstellationRepository constellationRepository,
                           AstronomerRepository astronomerRepository,
                           Gson gson, ModelMapper modelMapper,
                           ValidationUtilsImpl validationUtils) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.astronomerRepository = astronomerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(STAR_FILE_PATH));
    }

    @Override
    public String importStars() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<StarDTO> starDTOList = Arrays.stream(gson.fromJson(readStarsFileContent(), StarDTO[].class))
                .collect(Collectors.toList());

        for (StarDTO s : starDTOList) {
            Optional<Star> starExist = this.starRepository.findByName(s.getName());
            if (starExist.isPresent() || !validationUtils.isValid(s)) {
                sb.append("Invalid star");
                sb.append(System.lineSeparator());

                continue;
            }

            Star starToSave = modelMapper.map(s, Star.class);
            Optional<Constellation> constellation =
                    this.constellationRepository.findAllById(s.getConstellation().longValue());

            starToSave.setConstellation(constellation.get());
            this.starRepository.save(starToSave);
            sb.append(String.format("Successfully imported star %s - %.2f light years%n",
                    starToSave.getName(), starToSave.getLightYears()));
        }

        return sb.toString().trim();
    }

    @Override
    public String exportStars() {
        StringBuilder sb = new StringBuilder();
        StarType starType = StarType.RED_GIANT;

        List<Star> stars = this.starRepository.findByStarTypeOrderByLightYears(starType);

        for (Star s : stars) {
            List<Astronomer> byObservingStar = this.astronomerRepository.findByObservingStar(s);
            if (byObservingStar.isEmpty()) {
                sb.append(String.format("Star: %s%n", s.getName()));
                sb.append(String.format("   *Distance: %.2f light years%n", s.getLightYears()));
                sb.append(String.format("   **Description: %s%n", s.getDescription()));
                sb.append(String.format("   ***Constellation: %s%n", s.getConstellation().getName()));
            }
        }

        return sb.toString().trim();
    }
}
