package bg.softuni.SpringDataAutoMappingObjects;

import bg.softuni.SpringDataAutoMappingObjects.dtos.AddressDto;
import bg.softuni.SpringDataAutoMappingObjects.dtos.EmployeeDto;
import bg.softuni.SpringDataAutoMappingObjects.entities.Address;
import bg.softuni.SpringDataAutoMappingObjects.entities.Employee;
import bg.softuni.SpringDataAutoMappingObjects.services.AddressService;
import bg.softuni.SpringDataAutoMappingObjects.services.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Component
public class Main implements CommandLineRunner {

    private final AddressService addressService;
    private final EmployeeService employeeService;

    public Main(AddressService addressService, EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;
    }


    @Override
    public void run(String... args) throws Exception {
        ModelMapper modelMapper = new ModelMapper();

//        AddressDto addressDto = new AddressDto("Bulgaria", "Sofia");
//
//        Address address = modelMapper.map(addressDto, Address.class);
//
//        this.addressService.createAddress(addressDto);
//
//        EmployeeDto employeeDto = new EmployeeDto("Pe6o", "Pe6ev",
//                BigDecimal.valueOf(10L));
//        Employee employee = modelMapper.map(employeeDto, Employee.class);
//
//        this.employeeService.createEmployee(employeeDto);
//
//        System.out.println(address);
//        System.out.println(employee);

//        this.employeeService.findSubordinates(1L);

        System.out.println(this.employeeService.findNamesById(1));
    }
}
