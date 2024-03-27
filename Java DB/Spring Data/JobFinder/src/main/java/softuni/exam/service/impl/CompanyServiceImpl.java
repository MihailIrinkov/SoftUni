package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CompanyDTO;
import softuni.exam.models.dto.CompanyXmlRootDTO;
import softuni.exam.models.entity.Company;
import softuni.exam.repository.CompanyRepository;
import softuni.exam.service.CompanyService;
import softuni.exam.util.ValidationUtilsImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private static String COMPANY_FILE_PATH = "src/main/resources/files/xml/companies.xml";
    private final CompanyRepository companyRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public CompanyServiceImpl(CompanyRepository companyRepository,
                              XmlParser xmlParser,
                              ModelMapper modelMapper,
                              ValidationUtilsImpl validationUtils) {
        this.companyRepository = companyRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.companyRepository.count() > 0;
    }

    @Override
    public String readCompaniesFromFile() throws IOException {
        return Files.readString(Path.of(COMPANY_FILE_PATH));
    }

    @Override
    public String importCompanies() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<CompanyDTO> companies = xmlParser.fromFile(Path.of(COMPANY_FILE_PATH).toFile(),
                        CompanyXmlRootDTO.class)
                .getCompanies().stream().toList();

        for (CompanyDTO c : companies) {
            Optional<Company> company = this.companyRepository.findByName(c.getCompanyName());

            if (company.isPresent() || !validationUtils.isValid(c)) {
                sb.append("Invalid company");
                sb.append(System.lineSeparator());

                continue;
            }

            Company companyToSave = modelMapper.map(c, Company.class);
            this.companyRepository.save(companyToSave);
            sb.append(String.format("Successfully imported company %s - %d%n",
                    companyToSave.getName(), companyToSave.getCountry().getId()));
        }

        return sb.toString().trim();
    }
}
