package exam.repository;


import exam.model.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//ToDo:
@Repository
public interface TownRepository extends JpaRepository<Town, Long> {

    Optional<Town> findByName(String name);
}
