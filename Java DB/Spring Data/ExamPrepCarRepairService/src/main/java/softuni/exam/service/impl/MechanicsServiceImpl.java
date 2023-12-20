package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicImportDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
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
public class MechanicsServiceImpl implements MechanicsService {

    private static String MECHANICS_FILE_PATH = "src/main/resources/files/json/mechanics.json";
    private final MechanicsRepository mechanicRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtilsImpl validationUtils;

    @Autowired
    public MechanicsServiceImpl(MechanicsRepository mechanicRepository,
                                ModelMapper modelMapper,
                                Gson gson,
                                ValidationUtilsImpl validationUtils) {
        this.mechanicRepository = mechanicRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.mechanicRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(MECHANICS_FILE_PATH));
    }

    @Override
    public String importMechanics() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<MechanicImportDto> mechanicDtoList =
                Arrays.stream(gson.fromJson(readMechanicsFromFile(), MechanicImportDto[].class))
                        .collect(Collectors.toList());

        for (MechanicImportDto m : mechanicDtoList) {

            Optional<Mechanic> byFirstName =
                    this.mechanicRepository.findByFirstName(m.getFirstName());
            Optional<Mechanic> byEmail =
                    this.mechanicRepository.findByEmail(m.getEmail());

            if (byFirstName.isEmpty() && byEmail.isEmpty() && validationUtils.isValid(m)) {

                Mechanic mechanicToSave = modelMapper.map(m, Mechanic.class);
                this.mechanicRepository.save(mechanicToSave);

                sb.append(String.format("Successfully imported mechanic %s %s%n"
                        , m.getFirstName(), m.getLastName()));

            } else {
                sb.append("Invalid mechanic");
                sb.append(System.lineSeparator());
            }

        }

        return sb.toString().trim();
    }
}
