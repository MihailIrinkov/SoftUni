package bg.softuni.SpringDataAutoMappingObjects.services;

import bg.softuni.SpringDataAutoMappingObjects.dtos.EmployeeDto;
import bg.softuni.SpringDataAutoMappingObjects.dtos.EmployeeNamesDto;
import bg.softuni.SpringDataAutoMappingObjects.dtos.ManagerDto;
import bg.softuni.SpringDataAutoMappingObjects.entities.Employee;


public interface EmployeeService {

    Employee createEmployee(EmployeeDto employeeDto);

    ManagerDto findSubordinates(Long id);

    EmployeeNamesDto findNamesById(long id);
}
