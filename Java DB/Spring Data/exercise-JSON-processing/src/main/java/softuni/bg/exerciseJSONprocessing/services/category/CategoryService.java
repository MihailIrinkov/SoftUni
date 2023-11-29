package softuni.bg.exerciseJSONprocessing.services.category;

import softuni.bg.exerciseJSONprocessing.domain.models.category.CategorySummaryModel;

import java.io.IOException;
import java.util.List;

public interface CategoryService {

    List<CategorySummaryModel> findCategorySummary() throws IOException;

}
