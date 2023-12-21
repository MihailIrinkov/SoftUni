package bg.softuni.mvcdemo.services;

import bg.softuni.mvcdemo.dto.projects.ProjectBasicInfo;
import bg.softuni.mvcdemo.dto.projects.ProjectsWrapperDto;
import bg.softuni.mvcdemo.entity.Company;
import bg.softuni.mvcdemo.entity.Project;
import bg.softuni.mvcdemo.repositories.CompanyRepository;
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
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository,
                          ModelMapper modelMapper,
                          CompanyRepository companyRepository) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }

    public boolean areImported() {
        return this.projectRepository.count() > 0;
    }

    public String getXmlInfo() throws IOException {

        return String.join(
                "\n",
                Files.readAllLines(Path.of("src/main/resources/files/xmls/projects.xml"))
        );
    }

    public void importEntities() throws IOException, JAXBException {
        final String xmlContent = this.getXmlInfo().trim();

        final ByteArrayInputStream stream = new ByteArrayInputStream(xmlContent.getBytes());

        final JAXBContext jaxbContext = JAXBContext.newInstance(ProjectsWrapperDto.class);

        final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        final ProjectsWrapperDto projects =
                (ProjectsWrapperDto) unmarshaller.unmarshal(stream);

        List<Project> projectsToSave = projects.getProjects()
                .stream()
                .map(pDto -> this.modelMapper.map(pDto, Project.class))
                .toList();

        for (Project p : projectsToSave) {

            Optional<Company> firstByName =
                    this.companyRepository.findFirstByName(p.getCompany().getName());

            p.setCompany(firstByName.get());
        }


        this.projectRepository.saveAll(projectsToSave);
    }

    public String getAllFinishedProjects() {

        return this.projectRepository
                .findAllByIsFinished(true)
                .stream()
                .map(p -> modelMapper.map(p, ProjectBasicInfo.class))
                .map(ProjectBasicInfo::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
