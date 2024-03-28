package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownDTO;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TownServiceImpl implements TownService {

    private static String TOWN_FILE_PATH = "src/main/resources/files/json/towns.json";
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtilsImpl validationUtils;

    public TownServiceImpl(TownRepository townRepository,
                           ModelMapper modelMapper,
                           Gson gson,
                           ValidationUtilsImpl validationUtils) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
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
    public String importTowns() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<TownDTO> towns = Arrays.stream(gson.fromJson(readTownsFileContent(), TownDTO[].class))
                .toList();

        for (TownDTO t : towns) {
            Optional<Town> townExist = this.townRepository.findByTownName(t.getTownName());
            if (townExist.isPresent() || !validationUtils.isValid(t)) {
                sb.append("Invalid town");
                sb.append(System.lineSeparator());

                continue;
            }

            Town townToSave = modelMapper.map(t, Town.class);
            this.townRepository.save(townToSave);
            sb.append(String.format("Successfully imported town %s - %d%n",
                    townToSave.getTownName(), townToSave.getPopulation()));
        }

        return sb.toString().trim();
    }
}
