package softuni.bg.jsoncardealer.services.customer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.bg.jsoncardealer.domain.entities.Customer;
import softuni.bg.jsoncardealer.domain.models.CustomerOrderModel;
import softuni.bg.jsoncardealer.repositories.CustomerRepository;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static softuni.bg.jsoncardealer.constants.Pats.FIRST_OUTPUT_JSON;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    ModelMapper modelMapper = new ModelMapper();
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getALl() {
        return null;
    }

    @Override
    public List<Customer> findAllByBirthDateOrderByYoungDriver() throws IOException {

        final List<Customer> customerList =
                this.customerRepository.findAllByOrderByBirthDateAscIsYoungDriverDesc().stream().toList();

        final List<CustomerOrderModel> customerOrderModels = customerList
                .stream()
                .map(customer -> modelMapper
                        .map(customer, CustomerOrderModel.class))
                .toList();

        final FileWriter fileWriter = new FileWriter(FIRST_OUTPUT_JSON.toFile());

        gson.toJson(customerOrderModels, fileWriter);

        return customerList;
    }
}
