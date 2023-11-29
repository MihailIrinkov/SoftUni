package softuni.bg.exerciseJSONprocessing.domain.models.product.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.bg.exerciseJSONprocessing.domain.models.product.ProductImportModel;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductWrapperImportModel {

    @XmlElement(name = "product")
    private List<ProductImportModel> products;
}
