package bg.softuni.SpringDataAutoMappingObjects.repositories;

import bg.softuni.SpringDataAutoMappingObjects.dtos.EmployeeNamesDto;
import bg.softuni.SpringDataAutoMappingObjects.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {



    @Query("SELECT new bg.softuni.SpringDataAutoMappingObjects.dtos.EmployeeNamesDto(e.firstName, e.lastName)" +
            " FROM Employee AS e WHERE e.id = :id")
    EmployeeNamesDto findNamesById(long id);

    List<Employee> findAllByManagerId(Long id);

    Employee getEmployeeById(Long id);

}
