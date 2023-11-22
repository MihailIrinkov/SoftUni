package bg.softuni.SpringDataAutoMappingObjects.repositories;

import bg.softuni.SpringDataAutoMappingObjects.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
