package bg.softuni.mvcdemo.repositories;

import bg.softuni.mvcdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByAgeGreaterThan(Integer age);
}
