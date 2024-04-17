package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SellerDTO;
import softuni.exam.models.entity.Seller;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SellerService;
import softuni.exam.util.ValidationUtilImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements SellerService {

    private static String SELLER_FILE_PATH = "src/main/resources/files/json/sellers.json";
    private final SellerRepository sellerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilImpl validationUtil;

    public SellerServiceImpl(SellerRepository sellerRepository,
                             Gson gson,
                             ModelMapper modelMapper,
                             ValidationUtilImpl validationUtil) {
        this.sellerRepository = sellerRepository;
        this.gson = gson;
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
    public String importSellers() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<SellerDTO> sellers =
                Arrays.stream(gson.fromJson(readSellersFromFile(), SellerDTO[].class))
                        .collect(Collectors.toList());

        for (SellerDTO s : sellers) {
            Optional<Seller> exists = this.sellerRepository.findAllByLastName(s.getLastName());

            if (exists.isPresent() || !validationUtil.isValid(s)) {
                sb.append("Invalid seller");
                sb.append(System.lineSeparator());

                continue;
            }

            Seller sellerToSave = modelMapper.map(s, Seller.class);
            this.sellerRepository.save(sellerToSave);
            sb.append(String.format("Successfully imported seller %s %s%n",
                    sellerToSave.getFirstName(),
                    sellerToSave.getLastName()));
        }

        return sb.toString().trim();
    }
}
