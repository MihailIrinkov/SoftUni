package bg.softuni.usersystem.repositories;

import bg.softuni.usersystem.domain_entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, Long> {
}
