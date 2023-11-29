package softuni.bg.exerciseJSONprocessing.domain.models.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.bg.exerciseJSONprocessing.domain.models.product.ProductSoldModel;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserWithSoldProductsModel {

    private String firstname;

    private String lastname;

    private Set<ProductSoldModel> boughtProducts;

}
