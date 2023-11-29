package softuni.bg.exerciseJSONprocessing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bg.exerciseJSONprocessing.domain.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM `json-xml-exercise`.users \n" +
            "ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Optional<User> getRandomEntity();

    @Query
    List<User>
    findAllBySellingProductsBuyerIsNotNullOrderBySellingProductsBuyerLastNameAscSellingProductsBuyerFirstName();
}
