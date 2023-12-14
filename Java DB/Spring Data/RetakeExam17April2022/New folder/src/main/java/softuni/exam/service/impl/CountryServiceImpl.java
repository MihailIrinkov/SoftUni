package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountryImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    final private CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<Country> getByCountryName(String countryName) {
        return Optional.empty();
    }

    @Override
    public boolean areImported() {
        return this.countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {

        InputStream stream = this.getClass().getResourceAsStream("/files/json/countries.json");
        byte[] bytes = stream.readAllBytes();

        return new String(bytes);
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();
        Gson gson = new GsonBuilder().create();
        ModelMapper mapper = new ModelMapper();

        Path jsonPath =
                Path.of("src", "main", "resources", "files", "json", "countries.json");

        FileReader reader = new FileReader(jsonPath.toFile());

        CountryImportDto[] countryImportDto = gson.fromJson(reader, CountryImportDto[].class);

        for (CountryImportDto countryDto : countryImportDto) {
            if (countryDto.validate()) {

                Optional<Country> existing =
                        this.countryRepository.findByCountryName(countryDto.getCountryName());

                if (existing.isEmpty()) {
                    Country country = mapper.map(countryDto, Country.class);

                    countryRepository.save(country);

                    sb.append(String.format("Successfully imported country %s - %s%n",
                            countryDto.getCountryName(), countryDto.getCurrency()));
                } else {
                    System.out.println("Invalid country");
                }

            } else {
                sb.append(String.format("Invalid country%n"));
            }
        }

        reader.close();
        return sb.toString().trim();
    }
}
