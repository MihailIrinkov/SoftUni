package softuni.bg.exerciseJSONprocessing.domain.models.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.bg.exerciseJSONprocessing.domain.models.product.ProductDto;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserModelDto {

    private String firstName;

    private String lastName;

    private Integer age;

    private Set<ProductDto> sellingProducts;

    public UserWithSoldProducts toUserWithProductModel() {
        return new UserWithSoldProducts(firstName, lastName, age,
                ProductDto.toProductSoldWithCountDto(sellingProducts));
    }

}
