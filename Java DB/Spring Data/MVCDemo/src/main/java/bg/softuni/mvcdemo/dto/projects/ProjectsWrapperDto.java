package bg.softuni.mvcdemo.dto.projects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "projects")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectsWrapperDto {

    @XmlElement(name = "project")
    private List<ProjectImportDto> projects;

    public ProjectsWrapperDto() {
    }

    public List<ProjectImportDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectImportDto> projects) {
        this.projects = projects;
    }
}
