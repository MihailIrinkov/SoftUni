package softuni.bg.exerciseJSONprocessing.domain.models.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.bg.exerciseJSONprocessing.domain.entities.User;
import softuni.bg.exerciseJSONprocessing.domain.models.category.CategoryModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

    private String name;

    private BigDecimal price;

    private User buyer;

    private User seller;

    private Set<CategoryModel> categories;

    public static ProductSoldWithCountModel toProductSoldWithCountDto(Set<ProductDto> sellingProducts) {
        List<ProductBasicInfoModel> productBasicInfoModelStream =
                sellingProducts.stream()
                        .map(ProductDto::toProductBasicInfoModel)
                        .toList();
        return ProductSoldWithCountModel.productSoldWithCountDto(productBasicInfoModelStream);
    }

    private static ProductBasicInfoModel toProductBasicInfoModel(ProductDto product) {
        return new ProductBasicInfoModel(product.getName(), product.getPrice());
    }

}
