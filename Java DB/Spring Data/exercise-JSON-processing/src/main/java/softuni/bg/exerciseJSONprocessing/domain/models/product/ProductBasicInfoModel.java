package softuni.bg.exerciseJSONprocessing.domain.models.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class ProductBasicInfoModel {

    private String name;

    private BigDecimal price;

}
