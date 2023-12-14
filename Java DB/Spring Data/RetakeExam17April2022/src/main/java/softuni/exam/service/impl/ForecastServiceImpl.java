package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastImportDto;
import softuni.exam.models.dto.ForecastImportWrapperDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

import static softuni.exam.models.entity.DayOfWeek.SUNDAY;

@Service
public class ForecastServiceImpl implements ForecastService {

    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final ModelMapper mapper;

    @Autowired
    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, ModelMapper mapper) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {

        InputStream stream = this.getClass().getResourceAsStream("/files/xml/forecasts.xml");
        byte[] bytes = stream.readAllBytes();

        return new String(bytes);
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        JAXBContext context = JAXBContext.newInstance(ForecastImportWrapperDto.class);

        InputStream resourceAsStream = this.getClass().getResourceAsStream("/files/xml/forecasts.xml");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));

        Unmarshaller unmarshaller = context.createUnmarshaller();

        ForecastImportWrapperDto forecastImportWrapperDto = (ForecastImportWrapperDto) unmarshaller.unmarshal(bufferedReader);

        List<ForecastImportDto> forecastImportDto = forecastImportWrapperDto.getForecasts();

        for (ForecastImportDto forecastImport : forecastImportDto) {

            if (forecastImport.validate() && forecastImport.getDayOfWeek() != null) {

                Optional<Forecast> existing = this.forecastRepository
                        .findForecastByCityIdAndDayOfWeek(forecastImport.getCity(), forecastImport.getDayOfWeek());

                if (existing.isEmpty()) {
                    Forecast forecast = mapper.map(forecastImport, Forecast.class);
                    Optional<City> city = this.cityRepository.findById(forecastImport.getCity());

                    if (city.isPresent()) {
                        forecast.setCity(city.get());
                        forecast.setDayOfWeek(forecastImport.getDayOfWeek());
                    }
                    this.forecastRepository.save(forecast);

                    sb.append(String.format("Successfully import forecast %s - %.2f%n"
                            , forecast.getDayOfWeek().toString(), forecast.getMaxTemperature()));
                }

            } else {
                sb.append(String.format("Invalid forecast%n"));
            }
        }


        bufferedReader.close();
        return sb.toString().trim();
    }

    @Override
    public String exportForecasts() {
        StringBuilder sb = new StringBuilder();

        List<Forecast> forecasts = this.forecastRepository
                .findByDayOfWeekAndCityPopulationLessThanOrderByMaxTemperatureDescIdAsc
                        (SUNDAY, 150000);

        for (Forecast f : forecasts) {
            sb.append(String.format("City: %s:%n", f.getCity().getCityName()));
            sb.append(String.format("   -min temperature: %.2f%n", f.getMinTemperature()));
            sb.append(String.format("   --max temperature: %.2f%n", f.getMaxTemperature()));
            sb.append("   ---sunrise: ");
            sb.append(f.getSunrise());
            sb.append(System.lineSeparator());
            sb.append("   ----sunset: ");
            sb.append(f.getSunset());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
