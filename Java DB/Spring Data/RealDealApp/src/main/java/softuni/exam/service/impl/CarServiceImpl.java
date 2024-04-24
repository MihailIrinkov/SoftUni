package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarDTO;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.CarRepository;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.util.ValidationUtilImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private static String CAR_FILE_PATH = "src/main/resources/files/json/cars.json";
    private final CarRepository carRepository;
    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilImpl validationUtil;

    public CarServiceImpl(CarRepository carRepository, PictureRepository pictureRepository,
                          Gson gson,
                          ModelMapper modelMapper,
                          ValidationUtilImpl validationUtil) {
        this.carRepository = carRepository;
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.carRepository.count() > 0;
    }

    @Override
    public String readCarsFileContent() throws IOException {
        return Files.readString(Path.of(CAR_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<CarDTO> cars = Arrays.stream(gson.fromJson(readCarsFileContent(), CarDTO[].class))
                .collect(Collectors.toList());

        for (CarDTO c : cars) {
            Optional<Car> exists = this.carRepository.findByMakeAndModelAndKilometers(
                    c.getMake(), c.getModel(), c.getKilometers());

            if (exists.isPresent() || !validationUtil.isValid(c)) {
                sb.append("Invalid car");
                sb.append(System.lineSeparator());

                continue;
            }

            Car carToSave = modelMapper.map(c, Car.class);
            this.carRepository.save(carToSave);
            sb.append(String.format("Successfully imported car - %s - %s%n",
                    c.getMake(), c.getModel()));
        }

        return sb.toString().trim();
    }

    @Override
    public String getCarsOrderByPicturesCountThenByMake() {
        StringBuilder sb = new StringBuilder();

        List<Long> extractData = this.pictureRepository.extractData();

        for (Long car_id : extractData) {
            Car car = this.carRepository.findById(car_id).get();
            List<Picture> allCarPictures = this.pictureRepository.findAllByCar(car);
            sb.append(String.format("Car make - %s, model - %s\n" +
                            "\tKilometers - %d\n" +
                            "\tRegistered on - %s\n" +
                            "\tNumber of pictures - %d\n",
                    car.getMake(),
                    car.getModel(),
                    car.getKilometers(),
                    car.getRegisteredOn(),
                    allCarPictures.size()));
        }

        return sb.toString().trim();
    }
}
