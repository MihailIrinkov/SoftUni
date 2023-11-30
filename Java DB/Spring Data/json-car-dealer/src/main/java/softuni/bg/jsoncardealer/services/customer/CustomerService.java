package softuni.bg.jsoncardealer.services.customer;

import softuni.bg.jsoncardealer.domain.entities.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    List<Customer> getALl();

    List<Customer> findAllByBirthDateOrderByYoungDriver() throws IOException;
}
