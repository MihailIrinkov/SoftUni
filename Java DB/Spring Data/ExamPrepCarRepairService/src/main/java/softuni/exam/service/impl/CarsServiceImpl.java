package softuni.exam.service.impl;

import ch.qos.logback.classic.pattern.FileOfCallerConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarImportDto;
import softuni.exam.models.dto.CarImportRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtilsImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

// TODO: Implement all methods
@Service
public class CarsServiceImpl implements CarsService {

    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";
    private final CarsRepository carRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    @Autowired
    public CarsServiceImpl(CarsRepository carRepository,
                           XmlParser xmlParser,
                           ModelMapper modelMapper,
                           ValidationUtilsImpl validationUtils) {
        this.carRepository = carRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<CarImportDto> carsImport =
                xmlParser.fromFile(Path.of(CARS_FILE_PATH).toFile(), CarImportRootDto.class)
                        .getCars();

        for (CarImportDto c : carsImport) {

            Optional<Car> byPlateNumber = this.carRepository.findByPlateNumber(c.getPlateNumber());

            if (byPlateNumber.isEmpty() && validationUtils.isValid(c)) {
                Car carToSave = this.modelMapper.map(c, Car.class);
                carRepository.save(carToSave);

                sb.append(String.format("Successfully imported car %s - %s%n",
                        c.getCarMake(), c.getCarModel()));
            } else {
                sb.append("Invalid car");
                sb.append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
