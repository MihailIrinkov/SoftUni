package softuni.exam.service.impl;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryDTO;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtilsImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private static String COUNTRY_FILE_PATH = "src/main/resources/files/json/countries.json";
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ModelMapper modelMapper, ValidationUtilsImpl validationUtils) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFileContent() throws IOException {
        return Files.readString(Path.of(COUNTRY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<CountryDTO> countries =
                Arrays.stream(gson.fromJson(readCountriesFileContent(), CountryDTO[].class))
                        .collect(Collectors.toList());

        for (CountryDTO c : countries) {
            if (!validationUtils.isValid(c)) {
                sb.append("Invalid country");
                sb.append(System.lineSeparator());

                continue;
            }

            Country countryToSave = modelMapper.map(c, Country.class);
            this.countryRepository.save(countryToSave);
            sb.append(String.format("Successfully imported country %s - %s%n",
                    countryToSave.getName(), countryToSave.getCode()));
        }

        return sb.toString().trim();
    }
}
