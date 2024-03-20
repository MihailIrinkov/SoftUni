package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Constellation;

import java.util.Optional;

// TODO:
@Repository
public interface ConstellationRepository extends JpaRepository<Constellation, Long> {

    Optional<Constellation> findAllByName(String name);
    Optional<Constellation> findAllById(Long id);
}
