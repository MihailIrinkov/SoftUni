package bg.softuni.mvcdemo.services;

import bg.softuni.mvcdemo.dto.categories.CompaniesWrapperDto;
import bg.softuni.mvcdemo.entity.Company;
import bg.softuni.mvcdemo.repositories.CompanyRepository;
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
import java.util.stream.Stream;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public CompanyService(CompanyRepository companyRepository, ModelMapper modelMapper) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
    }

    public boolean areImported() {
        return this.companyRepository.count() > 0;
    }

    public String getXmlInfo() throws IOException {
        return String.join(
                "\n",
                Files.readAllLines(Path.of(
                        "src/main/resources/files/xmls/companies.xml"))
        );
    }

    public void importEntities() throws IOException, JAXBException {
        String xmlInfo = this.getXmlInfo();

        ByteArrayInputStream infoStream =
                new ByteArrayInputStream(xmlInfo.getBytes());

        JAXBContext context = JAXBContext.newInstance(CompaniesWrapperDto.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        CompaniesWrapperDto companies =
                (CompaniesWrapperDto) unmarshaller.unmarshal(infoStream);

        List<Company> companiesToSave = companies.getCompanies()
                .stream()
                .map(cDto -> this.modelMapper.map(cDto, Company.class))
                .toList();

        this.companyRepository.saveAll(companiesToSave);

    }
}
