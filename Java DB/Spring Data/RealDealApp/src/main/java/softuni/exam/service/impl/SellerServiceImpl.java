package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerDTO;
import softuni.exam.models.dto.SellerRootDTO;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtilImpl;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements SellerService {

    private static String SELLER_FILE_PATH = "src/main/resources/files/xml/sellers.xml";
    private final SellerRepository sellerRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtilImpl validationUtil;

    public SellerServiceImpl(SellerRepository sellerRepository,
                             XmlParser xmlParser,
                             ModelMapper modelMapper,
                             ValidationUtilImpl validationUtil) {
        this.sellerRepository = sellerRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.sellerRepository.count() > 0;
    }

    @Override
    public String readSellersFromFile() throws IOException {
        return Files.readString(Path.of(SELLER_FILE_PATH));
    }

    @Override
    public String importSellers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        List<SellerDTO> sellers = xmlParser.fromFile(Path.of(SELLER_FILE_PATH).toFile(), SellerRootDTO.class)
                .getSellers().stream().collect(Collectors.toList());

        for (SellerDTO s : sellers) {
            Optional<Seller> exists = this.sellerRepository.findByEmail(s.getEmail());
            if (exists.isPresent() || !validationUtil.isValid(s)) {
                sb.append("Invalid seller");
                sb.append(System.lineSeparator());

                continue;
            }

            Seller sellerToSave = modelMapper.map(s, Seller.class);
            this.sellerRepository.save(sellerToSave);
            sb.append(String.format("Successfully import seller %s - %s%n",
                    sellerToSave.getLastName(), sellerToSave.getEmail()));
        }

        return sb.toString().trim();
    }
}
