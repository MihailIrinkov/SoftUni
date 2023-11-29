package softuni.bg.exerciseJSONprocessing.domain.models.product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ProductSoldModel {

    private String name;

    private BigDecimal price;

    private String buyerFirstName;

    private String buyerLastName;


}
