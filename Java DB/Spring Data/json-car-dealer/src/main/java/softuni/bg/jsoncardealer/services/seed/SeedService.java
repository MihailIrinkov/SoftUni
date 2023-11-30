package softuni.bg.jsoncardealer.services.seed;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface SeedService {

    void seedCar() throws IOException;

    void  seedCustomer() throws FileNotFoundException;

    void seedPart() throws IOException;

    void seedSale();

    void seedSupplier() throws IOException;

    default void seedAll() throws IOException {
        seedCar();
        seedCustomer();
        seedPart();
        seedSale();
        seedSupplier();
    }
}
