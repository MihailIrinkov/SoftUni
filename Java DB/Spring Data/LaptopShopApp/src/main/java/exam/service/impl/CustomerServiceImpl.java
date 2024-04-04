package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.CustomerDTO;
import exam.model.entity.Customer;
import exam.repository.CustomerRepository;
import exam.repository.TownRepository;
import exam.service.CustomerService;
import exam.util.ValidationUtilsImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static String CUSTOMER_FILE_PATH = "src/main/resources/files/json/customers.json";
    private final CustomerRepository customerRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               TownRepository townRepository,
                               Gson gson,
                               ModelMapper modelMapper,
                               ValidationUtilsImpl validationUtils) {
        this.customerRepository = customerRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files.readString(Path.of(CUSTOMER_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<CustomerDTO> customers = Arrays.stream(gson.fromJson(readCustomersFileContent(), CustomerDTO[].class))
                .toList();

        for (CustomerDTO c : customers) {
            Optional<Customer> exist = this.customerRepository.findByEmail(c.getEmail());
            if (exist.isPresent() || !validationUtils.isValid(c)) {
                sb.append("Invalid Customer");
                sb.append(System.lineSeparator());

                continue;
            }

            Customer customerToSave = modelMapper.map(c, Customer.class);
            customerToSave.setTown(this.townRepository.findByName(c.getTown().getName()).get());
            this.customerRepository.save(customerToSave);
            sb.append(String.format("Successfully imported Customer %s %s - %s%n",
                    customerToSave.getFirstName(),
                    customerToSave.getLastName(),
                    customerToSave.getEmail()));
        }

        return sb.toString().trim();
    }
}
