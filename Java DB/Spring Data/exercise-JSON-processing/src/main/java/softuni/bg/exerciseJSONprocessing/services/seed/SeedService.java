package softuni.bg.exerciseJSONprocessing.services.seed;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public interface SeedService {

    void seedUser(String type) throws IOException, JAXBException;
    void seedCategories(String type) throws IOException, JAXBException;
    void seedProducts(String type) throws IOException, JAXBException, JAXBException;

    default void seedAll(String type) throws IOException, JAXBException {
        seedUser(type);
        seedCategories(type);
        seedProducts(type);
    }
}
