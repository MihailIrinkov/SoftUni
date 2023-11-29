package softuni.bg.exerciseJSONprocessing.services.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.bg.exerciseJSONprocessing.domain.models.product.ProductBasicInfoWithSellerFullName;
import softuni.bg.exerciseJSONprocessing.repositories.ProductRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static softuni.bg.exerciseJSONprocessing.constants.Pats.FIRST_JSON_PATH;
import static softuni.bg.exerciseJSONprocessing.constants.Utils.GSON;
import static softuni.bg.exerciseJSONprocessing.constants.Utils.writeIntoJsonFile;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductBasicInfoWithSellerFullName> getProductsInRangeWithNoBuyer(BigDecimal lowBoundary, BigDecimal highBoundary) throws IOException {

        final List<ProductBasicInfoWithSellerFullName> products = this.productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPrice(lowBoundary, highBoundary)
                .stream()
                .map(ProductBasicInfoWithSellerFullName ::getFromProduct).toList();

        System.out.println(GSON.toJson(products));

        writeIntoJsonFile(products, FIRST_JSON_PATH);

        return products;
    }

}
