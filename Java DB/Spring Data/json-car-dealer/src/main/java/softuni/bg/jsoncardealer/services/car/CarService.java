package softuni.bg.jsoncardealer.services.car;

import softuni.bg.jsoncardealer.domain.entities.Car;
import softuni.bg.jsoncardealer.domain.models.CarsWithPartsExportModel;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface CarService {

    Optional<Car> getById(Long id);

    List<Car> getAllByMakeOrderByModelAscTravelledDistanceDesc(String model) throws IOException;

//    CarsWithPartsExportModel getAll() throws IOException;

}
