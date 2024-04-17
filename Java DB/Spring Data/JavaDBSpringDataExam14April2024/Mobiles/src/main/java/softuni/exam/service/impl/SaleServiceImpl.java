package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.SaleDTO;
import softuni.exam.models.entity.Sale;
import softuni.exam.repository.SaleRepository;
import softuni.exam.repository.SellerRepository;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtilImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements SaleService {

    private static String SALE_FILE_PATH = "src/main/resources/files/json/sales.json";
    private final SaleRepository saleRepository;
    private final SellerRepository sellerRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtilImpl validationUtil;

    public SaleServiceImpl(SaleRepository saleRepository,
                           SellerRepository sellerRepository,
                           Gson gson,
                           ModelMapper modelMapper,
                           ValidationUtilImpl validationUtil) {
        this.saleRepository = saleRepository;
        this.sellerRepository = sellerRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.saleRepository.count() > 0;
    }

    @Override
    public String readSalesFileContent() throws IOException {
        return Files.readString(Path.of(SALE_FILE_PATH));
    }

    @Override
    public String importSales() throws IOException {
        StringBuilder sb = new StringBuilder();

        List<SaleDTO> sales =
                Arrays.stream(gson.fromJson(readSalesFileContent(), SaleDTO[].class))
                        .collect(Collectors.toList());

        for (SaleDTO s : sales) {
            Optional<Sale> exists =
                    this.saleRepository.findAllByNumber(s.getNumber());
            if (exists.isPresent() || !validationUtil.isValid(s)
            || s.getNumber().chars().count() != 7) {
                sb.append("Invalid sale");
                sb.append(System.lineSeparator());

                continue;
            }

            Sale saleToSave = modelMapper.map(s, Sale.class);
            saleToSave.setSeller(this.sellerRepository.findById(s.getSeller()).get());
            this.saleRepository.save(saleToSave);

            sb.append(String.format("Successfully imported sale with number %s%n",
                    saleToSave.getNumber()));
        }

        return sb.toString().trim();
    }
}
