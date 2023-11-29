package softuni.bg.exerciseJSONprocessing.domain.models.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
public class CategorySummaryModel {

    private String category;

    private Long productCount;

    private Double averagePrice;

    private BigDecimal totalRevenue;

}
