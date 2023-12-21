package bg.softuni.mvcdemo.dto.employees;

import bg.softuni.mvcdemo.dto.projects.ProjectImportDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeWrapperDto {

    @XmlElement(name = "employee")
    private List<EmployeeImportDto> employee;

    public EmployeeWrapperDto() {
    }

    public List<EmployeeImportDto> getEmployees() {
        return employee;
    }

    public void setEmployees(List<EmployeeImportDto> employees) {
        this.employee = employees;
    }
}
