package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartImportDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
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
public class PartsServiceImpl implements PartsService {

    private static String PARTS_FILE_PATH = "src/main/resources/files/json/parts.json";

    private final PartsRepository partRepository;

    private final ValidationUtilsImpl validationUtils;
    private final ModelMapper modelMapper;
    private final Gson gson;

    @Autowired
    public PartsServiceImpl(PartsRepository partRepository
            , ValidationUtilsImpl validationUtils
            , ModelMapper modelMapper
            , Gson gson) {
        this.partRepository = partRepository;
        this.validationUtils = validationUtils;
        this.modelMapper = modelMapper;
        this.gson = gson;
    }

    @Override
    public boolean areImported() {
        return this.partRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(PARTS_FILE_PATH));
    }

    @Override
    public String importParts() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<PartImportDto> partsDto = Arrays.stream(gson.fromJson(readPartsFileContent(), PartImportDto[].class))
                .collect(Collectors.toList());

        for (PartImportDto partDto : partsDto) {

            Optional<Part> partExisting = this.partRepository.findByPartName(partDto.getPartName());

            if (partExisting.isEmpty() && validationUtils.isValid(partDto)) {

                Part partToSave = modelMapper.map(partDto, Part.class);

                this.partRepository.save(partToSave);

                sb.append(String.format("Successfully imported part %s - %s%n",
                        partDto.getPartName(),
                        partDto.getPrice()));

            } else {
                sb.append("Invalid part");
                sb.append(System.lineSeparator());
            }

        }
        return sb.toString().trim();
    }
}
