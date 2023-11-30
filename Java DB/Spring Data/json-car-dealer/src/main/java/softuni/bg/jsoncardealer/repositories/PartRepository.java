package softuni.bg.jsoncardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bg.jsoncardealer.domain.entities.Part;

import java.util.Optional;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {

    @Query(value = "SELECT * FROM `json-car-dealer`.parts ORDER BY RAND() LIMIT 1;"
            , nativeQuery = true)
    Optional<Part> getRandomEntity();


}
