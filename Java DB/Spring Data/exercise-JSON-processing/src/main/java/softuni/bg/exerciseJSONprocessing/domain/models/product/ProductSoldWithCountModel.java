package softuni.bg.exerciseJSONprocessing.domain.models.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ProductSoldWithCountModel {

    private Integer count;

    private List<ProductBasicInfoModel> products;

    public static ProductSoldWithCountModel productSoldWithCountDto(List<ProductBasicInfoModel> products) {
        return new ProductSoldWithCountModel(products.size(), products);
    }

}
