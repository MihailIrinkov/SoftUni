package softuni.bg.jsoncardealer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bg.jsoncardealer.domain.entities.Customer;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT * FROM `json-car-dealer`.customers ORDER BY RAND() LIMIT 1;"
            , nativeQuery = true)
    Optional<Customer> getRandomCustomer();

    List<Customer> findAllByOrderByBirthDateAscIsYoungDriverDesc();
}
