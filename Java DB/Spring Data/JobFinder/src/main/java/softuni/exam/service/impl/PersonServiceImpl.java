package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PersonDTO;
import softuni.exam.models.entity.Person;
import softuni.exam.repository.CountryRepository;
import softuni.exam.repository.PersonRepository;
import softuni.exam.service.PersonService;
import softuni.exam.util.ValidationUtilsImpl;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private static String PERSON_FILE_PATH = "src/main/resources/files/json/people.json";
    private final PersonRepository personRepository;
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public PersonServiceImpl(PersonRepository personRepository,
                             CountryRepository countryRepository,
                             Gson gson,
                             ModelMapper modelMapper,
                             ValidationUtilsImpl validationUtils) {
        this.personRepository = personRepository;
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.personRepository.count() > 0;
    }

    @Override
    public String readPeopleFromFile() throws IOException {
        return Files.readString(Path.of(PERSON_FILE_PATH));
    }

    @Override
    public String importPeople() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<PersonDTO> people = Arrays.stream(gson.fromJson(readPeopleFromFile(), PersonDTO[].class))
                .toList();

        for (PersonDTO p : people) {
            Optional<Person> byFirstName = this.personRepository.findByFirstName(p.getFirstName());
            Optional<Person> byEmail = this.personRepository.findByEmail(p.getEmail());
            Optional<Person> byPhone = this.personRepository.findByPhone(p.getPhone());

            if (byFirstName.isPresent() || byEmail.isPresent() || byPhone.isPresent()
                    || !validationUtils.isValid(p)) {
                sb.append("Invalid person");
                sb.append(System.lineSeparator());

                continue;
            }

            Person personToSave = modelMapper.map(p, Person.class);

            personToSave.setCountry(this.countryRepository
                    .findById(p.getCountry().longValue()).get());
            this.personRepository.save(personToSave);
            sb.append(String.format("Successfully imported person %s %s%n",
                    personToSave.getFirstName(), personToSave.getLastName()));
        }

        return sb.toString().trim();
    }
}
