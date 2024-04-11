package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entities.Passenger;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{
    Optional<Passenger> findAllByEmail(String email);
    List<Passenger> findAllByOrderByEmailAsc();

    Optional<Passenger> findById(Long id);
}
