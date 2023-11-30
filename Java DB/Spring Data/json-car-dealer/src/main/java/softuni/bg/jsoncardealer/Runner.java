package softuni.bg.jsoncardealer;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.jsoncardealer.domain.entities.Car;
import softuni.bg.jsoncardealer.domain.entities.Part;
import softuni.bg.jsoncardealer.services.car.CarService;
import softuni.bg.jsoncardealer.services.customer.CustomerService;
import softuni.bg.jsoncardealer.services.seed.SeedService;
import softuni.bg.jsoncardealer.services.supplier.SupplierService;

import java.util.List;
import java.util.Optional;

@Component
public class Runner implements CommandLineRunner {

    private final SeedService seedService;

    private final CarService carService;

    private final CustomerService customerService;

    private final SupplierService supplierService;

    public Runner(SeedService seedService, CarService carService, CustomerService customerService, SupplierService supplierService) {
        this.seedService = seedService;
        this.carService = carService;
        this.customerService = customerService;
        this.supplierService = supplierService;
    }

    @Override
    public void run(String... args) throws Exception {

        seedService.seedSupplier();

        seedService.seedPart();

        seedService.seedCar();

        seedService.seedCustomer();

        seedService.seedSale();

        supplierService.getAllByIsImporterTrue();

//        carService.getAll();


        final Optional<Car> carById = this.carService.getById(100L);

        List<Part> parts = carById.get().getParts();

        for (int i = 0; i < parts.size(); i++) {
            System.out.println(parts.get(i).getName());
        }

        customerService.findAllByBirthDateOrderByYoungDriver();

        this.carService.getAllByMakeOrderByModelAscTravelledDistanceDesc("Toyota");

    }
}
