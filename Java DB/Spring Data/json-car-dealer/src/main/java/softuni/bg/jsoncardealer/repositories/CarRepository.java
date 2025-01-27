package softuni.bg.jsoncardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bg.jsoncardealer.domain.entities.Car;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT * FROM `json-car-dealer`.cars ORDER BY RAND() LIMIT 1;"
            ,nativeQuery = true)
    Optional<Car> getRandomCar();
    Optional<Car> findById(Long id);

    List<Car> findAllByMakeOrderByModelAscTravelledDistanceDesc(String model);

    List<Car> findAll();

}
