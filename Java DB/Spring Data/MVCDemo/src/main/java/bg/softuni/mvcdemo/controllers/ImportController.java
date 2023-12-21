package bg.softuni.mvcdemo.controllers;


import bg.softuni.mvcdemo.services.CompanyService;
import bg.softuni.mvcdemo.services.EmployeeService;
import bg.softuni.mvcdemo.services.ProjectService;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class ImportController {

    private final CompanyService companyService;
    private final ProjectService projectService;

    private final EmployeeService employeeService;

    @Autowired
    public ImportController(CompanyService companyService,
                            ProjectService projectService,
                            EmployeeService employeeService) {
        this.companyService = companyService;
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    @GetMapping("import/xml")
    public String mainView(Model model) {

        boolean[] importedStatus =
                {
                        this.companyService.areImported(),
                        this.projectService.areImported(),
                        this.employeeService.areImported()
                };

        model.addAttribute("areImported", importedStatus);

        return "xml/import-xml";
    }

    @GetMapping("import/companies")
    public String getImportCompanies(Model model) throws IOException {
        model.addAttribute("companies", this.companyService.getXmlInfo());
        return "xml/import-companies";
    }

    @PostMapping("import/companies")
    public String postCompanies() throws IOException, JAXBException {

        String xmlInfo = this.companyService.getXmlInfo();
        this.companyService.importEntities();

        return "redirect:/import/xml";
    }


    @GetMapping("import/projects")
    public String getImportProjects(Model model) throws IOException {
        model.addAttribute("projects", this.projectService.getXmlInfo());

        return "xml/import-projects";
    }

    @GetMapping("import/employees")
    public String getImportEmployees(Model model) throws IOException {
        model.addAttribute("employees", this.employeeService.getXmlInfo());

        return "xml/import-employees";
    }

    @PostMapping("import/projects")
    public String postProjects() throws IOException, JAXBException {
        this.projectService.importEntities();

        return "redirect:/import/xml";
    }

    @PostMapping("import/employees")
    public String postEmployees() throws IOException, JAXBException {
        this.employeeService.importEntities();

        return "redirect:/import/xml";
    }

}
