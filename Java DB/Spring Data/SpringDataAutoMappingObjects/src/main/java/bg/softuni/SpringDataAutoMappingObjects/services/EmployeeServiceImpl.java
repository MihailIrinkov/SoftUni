package bg.softuni.SpringDataAutoMappingObjects.services;

import bg.softuni.SpringDataAutoMappingObjects.dtos.EmployeeDto;
import bg.softuni.SpringDataAutoMappingObjects.dtos.EmployeeNamesDto;
import bg.softuni.SpringDataAutoMappingObjects.dtos.ManagerDto;
import bg.softuni.SpringDataAutoMappingObjects.entities.Employee;
import bg.softuni.SpringDataAutoMappingObjects.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {

        ModelMapper modelMapper = new ModelMapper();

        Employee employee = modelMapper.map(employeeDto, Employee.class);

        employee = this.employeeRepository.save(employee);

        return employee;
    }

    @Override
    public ManagerDto findSubordinates(Long id) {

        ModelMapper modelMapper = new ModelMapper();

        final List<Employee> listOfSubordinates = this.employeeRepository.findAllByManagerId(id);

        ManagerDto managerDto = modelMapper.map(this.employeeRepository.getEmployeeById(id), ManagerDto.class);

        System.out.printf("%s %s | Employees: %d%n", managerDto.getFirstName(), managerDto.getLastName(), listOfSubordinates.size());

        for (Employee e :listOfSubordinates) {
            System.out.printf("- %s %s %s%n", e.getFirstName(), e.getLastName(), e.getSalary());
        }

        return managerDto;
    }

    @Override
    public EmployeeNamesDto findNamesById(long id) {
        return this.employeeRepository.findNamesById(id);
    }


}
