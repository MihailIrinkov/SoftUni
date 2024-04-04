package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopDTO;
import exam.model.entity.Laptop;
import exam.repository.LaptopRepository;
import exam.repository.ShopRepository;
import exam.service.LaptopService;
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
public class LaptopServiceImpl implements LaptopService {

    private static String LAPTOP_FILE_PATH = "src/main/resources/files/json/laptops.json";
    private final LaptopRepository laptopRepository;
    private ShopRepository shopRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public LaptopServiceImpl(LaptopRepository laptopRepository,
                             ShopRepository shopRepository,
                             Gson gson,
                             ModelMapper modelMapper,
                             ValidationUtilsImpl validationUtils) {
        this.laptopRepository = laptopRepository;
        this.shopRepository = shopRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files.readString(Path.of(LAPTOP_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<LaptopDTO> laptops =
                Arrays.stream(gson.fromJson(readLaptopsFileContent(), LaptopDTO[].class))
                        .toList();

        for (LaptopDTO l : laptops) {
            Optional<Laptop> exists = this.laptopRepository.findByMacAddress(l.getMacAddress());
            if (exists.isPresent() || !validationUtils.isValid(l)) {
                sb.append("Invalid Laptop");
                sb.append(System.lineSeparator());

                continue;
            }

            Laptop laptopToSave = modelMapper.map(l, Laptop.class);
            laptopToSave.setShop(this.shopRepository.findByName(l.getShop().getName()).get());
            this.laptopRepository.save(laptopToSave);

//            laptop mac address – cpu – ram -hdd
            sb.append(String.format("Successfully imported Laptop %s - %.2f - %d - %d%n",
                    laptopToSave.getMacAddress(),
                    laptopToSave.getCpuSpeed(),
                    laptopToSave.getRam(),
                    laptopToSave.getStorage()));
        }

        return sb.toString().trim();
    }

    @Override
    public String exportBestLaptops() {
        StringBuilder sb = new StringBuilder();

        List<Laptop> laptops =
                this.laptopRepository.findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc();

        for (Laptop l : laptops) {
            sb.append(String.format("Laptop - %s%n", l.getMacAddress()));
            sb.append(String.format("*Cpu speed - %.2f%n", l.getCpuSpeed()));
            sb.append(String.format("**Ram - %d%n", l.getRam()));
            sb.append(String.format("***Storage - %d%n", l.getStorage()));
            sb.append(String.format("****Price - %s%n", l.getPrice().setScale(2)));
            sb.append(String.format("#Shop name - %s%n", l.getShop().getName()));
            sb.append(String.format("##Town - %s%n", l.getShop().getTown().getName()));

        }

        return sb.toString().trim();
    }
}
