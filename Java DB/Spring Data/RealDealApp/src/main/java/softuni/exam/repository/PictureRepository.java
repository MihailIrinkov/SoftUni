package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Car;
import softuni.exam.models.entity.Picture;

import java.util.List;
import java.util.Optional;

//ToDo
@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {

    Optional<Picture> findByName(String name);
    List<Picture> findAllByCar(Car car);

    @Query(value = "SELECT p.car_id, c.make, COUNT(p.car_id) FROM pictures as p\n" +
            "JOIN cars as c ON p.car_id = c.id\n" +
            "GROUP BY p.car_id ORDER BY COUNT(p.car_id) DESC, c.make ASC;",
            nativeQuery = true)
    List<Long> extractData();
}
