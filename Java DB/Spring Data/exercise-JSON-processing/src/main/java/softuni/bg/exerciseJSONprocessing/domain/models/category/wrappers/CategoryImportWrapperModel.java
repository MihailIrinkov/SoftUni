package softuni.bg.exerciseJSONprocessing.domain.models.category.wrappers;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import softuni.bg.exerciseJSONprocessing.domain.models.category.CategoryImportModel;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryImportWrapperModel {

    @XmlElement(name = "category")
    List<CategoryImportModel> categories;
}
