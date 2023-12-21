package bg.softuni.mvcdemo.services;

import bg.softuni.mvcdemo.dto.employees.EmployeeBasicInfo;
import bg.softuni.mvcdemo.dto.employees.EmployeeWrapperDto;
import bg.softuni.mvcdemo.entity.Company;
import bg.softuni.mvcdemo.entity.Employee;
import bg.softuni.mvcdemo.entity.Project;
import bg.softuni.mvcdemo.repositories.CompanyRepository;
import bg.softuni.mvcdemo.repositories.EmployeeRepository;
import bg.softuni.mvcdemo.repositories.ProjectRepository;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;
    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository,
                           ProjectRepository projectRepository,
                           CompanyRepository companyRepository,
                           ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    public boolean areImported() {
        return this.employeeRepository.count() > 0;
    }

    public String getXmlInfo() throws IOException {
        return String.join(
                "\n",
                Files.readAllLines(
                        Path.of("src/main/resources/files/xmls/employees.xml"))
        );
    }

    public void importEntities() throws IOException, JAXBException {
        final String xmlContent = this.getXmlInfo().trim();

        final ByteArrayInputStream stream =
                new ByteArrayInputStream(xmlContent.getBytes());

        final JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeWrapperDto.class);
        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        EmployeeWrapperDto employees = (EmployeeWrapperDto) unmarshaller.unmarshal(stream);

        List<Employee> employeesToSave = employees.getEmployees().stream()
                .map(e -> modelMapper.map(e, Employee.class))
                .toList();

        for (Employee e : employeesToSave) {

            Optional<Company> company =
                    this.companyRepository.findFirstByName(e.getProject().getCompany().getName());

            e.getProject().setCompany(company.get());

            Optional<Project> project = this.projectRepository.findFirstByName(e.getProject().getName());
            e.setProject(project.get());

        }

        this.employeeRepository.saveAll(employeesToSave);
    }

    public String getEmployeesOverAge(int age) {
        return this.employeeRepository.findAllByAgeGreaterThan(age)
                .stream()
                .map(EmployeeBasicInfo::fromEmployee)
                .map(EmployeeBasicInfo::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
