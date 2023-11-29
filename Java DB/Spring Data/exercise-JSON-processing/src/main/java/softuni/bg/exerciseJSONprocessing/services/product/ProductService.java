package softuni.bg.exerciseJSONprocessing.services.product;

import softuni.bg.exerciseJSONprocessing.domain.models.product.ProductBasicInfoWithSellerFullName;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    List<ProductBasicInfoWithSellerFullName> getProductsInRangeWithNoBuyer(
            BigDecimal lowBoundary, BigDecimal highBoundary) throws IOException;

}
