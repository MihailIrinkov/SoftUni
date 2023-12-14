package softuni.exam.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CityImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    final private CityRepository cityRepository;
    final private CountryRepository countryRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public Optional<City> getByCityName(String cityName) {
        return Optional.empty();
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        InputStream streamCities = this.getClass().getResourceAsStream("/files/json/cities.json");
        byte[] bytes = streamCities.readAllBytes();

        return new String(bytes);
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();
        Gson gson = new GsonBuilder().create();
        ModelMapper mapper = new ModelMapper();

        Path pathCitiesJson = Path.of("src", "main", "resources", "files", "json", "cities.json");

        FileReader fileReader = new FileReader(pathCitiesJson.toFile());

        CityImportDto[] cityImportDtos = gson.fromJson(fileReader, CityImportDto[].class);

        for (CityImportDto cityImportDto: cityImportDtos) {

            Optional<Country>country = this.countryRepository.findById(cityImportDto.getCountry());

            if (country.isEmpty()) {
                sb.append(String.format("Invalid city%n"));
                continue;
            }

            if (cityImportDto.validate()) {

                Optional<City> existing = this.cityRepository.findByCityName(cityImportDto.getCityName());

                if(existing.isEmpty()) {

                    if (cityImportDto.validate()) {
                        City city = mapper.map(cityImportDto, City.class);
                        city.setCountry(country.get());
                        cityRepository.save(city);

                        sb.append(String.format("Successfully imported city %s - %d%n"
                                , city.getCityName(), city.getPopulation()));
                    }

                } else {
                    sb.append(String.format("Invalid city%n"));
                }

            } else {
                sb.append(String.format("Invalid city%n"));
            }

        }

        fileReader.close();
        return sb.toString().trim();
    }
}
