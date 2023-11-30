package softuni.bg.jsoncardealer.services.car;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.jsoncardealer.domain.entities.Car;
import softuni.bg.jsoncardealer.domain.models.CarFromMakeExportModel;
import softuni.bg.jsoncardealer.domain.models.CarsWithPartsExportModel;
import softuni.bg.jsoncardealer.repositories.CarRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static softuni.bg.jsoncardealer.constants.Pats.FOURTH_OUTPUT_JSON;
import static softuni.bg.jsoncardealer.constants.Pats.SECOND_OUTPUT_JSON;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    ModelMapper modelMapper = new ModelMapper();

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Optional<Car> getById(Long id) {

        final Optional<Car> car = this.carRepository.findById(id);

        return car;
    }

    @Override
    public List<Car> getAllByMakeOrderByModelAscTravelledDistanceDesc(String model) throws IOException {

        final List<CarFromMakeExportModel> carsFromMake = this.carRepository.findAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota")
                .stream()
                .map(car -> modelMapper.map(car, CarFromMakeExportModel.class))
                .toList();

        final FileWriter fileWriter = new FileWriter(SECOND_OUTPUT_JSON.toFile());

        gson.toJson(carsFromMake, fileWriter);

        return null;
    }

//    @Override
//    public CarsWithPartsExportModel getAll() throws IOException {
//
//        final List<CarsWithPartsExportModel> carsWithPartsExportModels = this.carRepository.findAll()
//                .stream()
//                .map(car -> modelMapper
//                        .map(car, CarsWithPartsExportModel.class))
//                .toList();
//
//        FileWriter fileWriter = new FileWriter(FOURTH_OUTPUT_JSON.toFile());
//
//        gson.toJson(carsWithPartsExportModels, fileWriter);
//
//        return null;
//    }


}
