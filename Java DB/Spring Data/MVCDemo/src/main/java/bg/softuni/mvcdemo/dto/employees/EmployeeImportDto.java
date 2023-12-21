package bg.softuni.mvcdemo.dto.employees;

import bg.softuni.mvcdemo.dto.projects.ProjectImportDto;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeImportDto {

    @XmlElement(name = "first-name")
    private String firstName;

    @XmlElement(name = "last-name")
    private String lastName;

    @XmlElement(name = "age")
    private int age;

    @XmlElement(name = "project")
    private ProjectImportDto project;


    public EmployeeImportDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public ProjectImportDto getProject() {
        return project;
    }

    public void setProject(ProjectImportDto project) {
        this.project = project;
    }
}
