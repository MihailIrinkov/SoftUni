package softuni.bg.jsoncardealer.services.seed;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.bg.jsoncardealer.domain.entities.*;
import softuni.bg.jsoncardealer.domain.models.CarImportModel;
import softuni.bg.jsoncardealer.domain.models.CustomerImportModel;
import softuni.bg.jsoncardealer.domain.models.PartImportModel;
import softuni.bg.jsoncardealer.domain.models.SupplierImportModel;
import softuni.bg.jsoncardealer.repositories.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

import static softuni.bg.jsoncardealer.constants.Pats.*;

@Service
public class SeedServiceImpl implements SeedService {

    private final SupplierRepository supplierRepository;

    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;
    private final PartRepository partRepository;
    private final SaleRepository saleRepository;

    public SeedServiceImpl(SupplierRepository supplierRepository, CarRepository carRepository, CustomerRepository customerRepository, PartRepository partRepository, SaleRepository saleRepository) {
        this.supplierRepository = supplierRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
        this.partRepository = partRepository;
        this.saleRepository = saleRepository;
    }

    @Override
    public void seedCar() throws IOException {

        if (this.carRepository.count() > 0) return;

        FileReader fileReader = new FileReader(CARS_JSON_PATH.toFile());

        ModelMapper modelMapper = new ModelMapper();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        final List<Car> carsToSave = Arrays.stream(gson.fromJson(fileReader, CarImportModel[].class))
                .map(c -> modelMapper.map(c, Car.class))
                .map(this::setRandomPart)
                .toList();

        this.carRepository.saveAll(carsToSave);

        fileReader.close();

    }

    @Override
    public void seedCustomer() throws FileNotFoundException {

        if (this.customerRepository.count() > 0) return;

        final FileReader fileReader = new FileReader(CUSTOMERS_JSON_PATH.toFile());

        ModelMapper modelMapper = new ModelMapper();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        final List<Customer> customersToSave = Arrays.stream(gson.fromJson(fileReader, CustomerImportModel[].class))
                .map(customerImportModel ->
                        modelMapper.map(customerImportModel, Customer.class))
                .toList();

        this.customerRepository.saveAll(customersToSave);
    }

    @Override
    public void seedPart() throws IOException {

        if (this.partRepository.count() > 0) return;

        final FileReader fileReader = new FileReader(PARTS_JSON_PATH.toFile());

        ModelMapper modelMapper = new ModelMapper();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        final List<Part> partsToSave = Arrays.stream(gson.fromJson(fileReader, PartImportModel[].class))
                .map(partImportModel -> modelMapper
                        .map(partImportModel, Part.class))
                .map(this::setRandomSupplier).toList();

        this.partRepository.saveAll(partsToSave);

        fileReader.close();
    }

    @Override
    public void seedSale() {

        if (this.saleRepository.count() > 0) return;

        Long countOfSales = this.customerRepository.count();

        List<Sale> salesToSafe = new ArrayList<>();

        for (int i = 0; i < countOfSales; i++) {
            Sale sale = new Sale();
            sale.setCustomer(this.customerRepository.getRandomCustomer().get());
            sale.setCar(this.carRepository.getRandomCar().get());
            sale.setDiscountPercentage(getRandomDiscountPercentage());

            salesToSafe.add(sale);
        }

        this.saleRepository.saveAll(salesToSafe);

    }

    private Double getRandomDiscountPercentage() {

        Random random = new Random();

        int randomInt = random.nextInt(1, 9);

        double percentage = 0;

        switch (randomInt) {
            case 1 -> percentage = 0;
            case 2 -> percentage = 5;
            case 3 -> percentage = 10;
            case 4 -> percentage = 15;
            case 5 -> percentage = 20;
            case 6 -> percentage = 30;
            case 7 -> percentage = 40;
            case 8 -> percentage = 50;

        }

        return percentage;
    }

    @Override
    public void seedSupplier() throws IOException {

        if (this.supplierRepository.count() > 0) return;

        final FileReader fileReader = new FileReader(SUPPLIERS_JSON_PATH.toFile());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        ModelMapper modelMapper = new ModelMapper();

        final List<Supplier> suppliersToSave = Arrays.stream(gson.fromJson(fileReader, SupplierImportModel[].class))
                .map(s -> modelMapper.map(s, Supplier.class))
                .toList();

        this.supplierRepository.saveAll(suppliersToSave);

        fileReader.close();
    }

    private Part setRandomSupplier(Part part) {

        Supplier supplier =
                this.supplierRepository.getRandomEntity()
                        .orElseThrow(NoSuchElementException::new);

        part.setSupplier(supplier);

        return part;
    }

    private Car setRandomPart(Car car) {

        Random random = new Random();

        int randomPartsQty = random.nextInt(3, 6);

        List<Part> partList = new ArrayList<>();

        for (int i = 0; i < randomPartsQty; i++) {

            Part part = this.partRepository.getRandomEntity()
                    .orElseThrow(NoSuchElementException::new);

            partList.add(part);

        }

        car.setParts(partList);

        return car;
    }

    private Sale setRandomCar(Sale sale) {

        Car car = this.carRepository.getRandomCar()
                .orElseThrow(NoSuchElementException::new);

        sale.setCar(car);

        return sale;
    }

    private Sale setRandomCustomer(Sale sale) {

        Customer customer = this.customerRepository.getRandomCustomer()
                .orElseThrow(NoSuchElementException::new);

        sale.setCustomer(customer);

        return sale;
    }

}
