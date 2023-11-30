package softuni.bg.jsoncardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bg.jsoncardealer.domain.entities.Supplier;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query(value = "SELECT * FROM `json-car-dealer`.suppliers ORDER BY RAND() LIMIT 1;",
    nativeQuery = true)
    Optional<Supplier> getRandomEntity();

    List<Supplier> findAllByIsImporterFalse();

}
