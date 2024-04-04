package exam.service;

import org.springframework.stereotype.Service;

import java.io.IOException;

//ToDo - Implement all methods

public interface CustomerService {

    boolean areImported();

    String readCustomersFileContent() throws IOException;

    String importCustomers() throws IOException;

}
