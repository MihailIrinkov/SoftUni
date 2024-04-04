package exam.service.impl;

import exam.model.dto.ShopDTO;
import exam.model.dto.ShopRootDTO;
import exam.model.entity.Shop;
import exam.repository.ShopRepository;
import exam.repository.TownRepository;
import exam.service.ShopService;
import exam.util.ValidationUtilsImpl;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    private static String SHOP_FILE_PATH = "src/main/resources/files/xml/shops.xml";
    private final ShopRepository shopRepository;
    private final TownRepository townRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilsImpl validationUtils;

    public ShopServiceImpl(ShopRepository shopRepository,
                           TownRepository townRepository,
                           XmlParser xmlParser,
                           ModelMapper modelMapper,
                           ValidationUtilsImpl validationUtils) {
        this.shopRepository = shopRepository;
        this.townRepository = townRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtils = validationUtils;
    }

    @Override
    public boolean areImported() {
        return this.shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files.readString(Path.of(SHOP_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        List<ShopDTO> shops = xmlParser.fromFile(Path.of(SHOP_FILE_PATH).toFile(), ShopRootDTO.class)
                .getShops().stream().toList();

        for (ShopDTO s : shops) {
            Optional<Shop> exist = this.shopRepository.findByName(s.getName());
            if (exist.isPresent() || !validationUtils.isValid(s)) {
                sb.append("Invalid shop");
                sb.append(System.lineSeparator());

                continue;
            }

            Shop shopToSave = modelMapper.map(s, Shop.class);
            shopToSave.setTown(this.townRepository.findByName(s.getTown().getName()).get());
            this.shopRepository.save(shopToSave);
            sb.append(String.format("Successfully imported Shop %s - %s%n",
                    shopToSave.getName(), shopToSave.getIncome()));
        }

        return sb.toString().trim();
    }
}
