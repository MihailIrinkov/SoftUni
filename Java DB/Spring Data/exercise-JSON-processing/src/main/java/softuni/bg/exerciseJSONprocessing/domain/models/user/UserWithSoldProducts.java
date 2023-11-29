package softuni.bg.exerciseJSONprocessing.domain.models.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import softuni.bg.exerciseJSONprocessing.domain.models.product.ProductSoldWithCountModel;

@Getter
@Setter
@AllArgsConstructor
public class UserWithSoldProducts {

    private String firstName;

    private String lastName;

    private Integer age;

    private ProductSoldWithCountModel soldProducts;
}
