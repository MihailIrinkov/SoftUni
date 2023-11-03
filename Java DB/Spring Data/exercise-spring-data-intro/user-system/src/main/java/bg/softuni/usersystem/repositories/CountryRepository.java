package bg.softuni.usersystem.repositories;

import bg.softuni.usersystem.domain_entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByNameEndingWith(String input);
}
