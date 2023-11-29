package softuni.bg.exerciseJSONprocessing.services.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.bg.exerciseJSONprocessing.domain.models.category.CategorySummaryModel;
import softuni.bg.exerciseJSONprocessing.repositories.CategoryRepository;

import java.io.IOException;
import java.util.List;

import static softuni.bg.exerciseJSONprocessing.constants.Pats.THIRD_JSON_PATH;
import static softuni.bg.exerciseJSONprocessing.constants.Utils.MODEL_MAPPER;
import static softuni.bg.exerciseJSONprocessing.constants.Utils.writeIntoJsonFile;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategorySummaryModel> findCategorySummary() throws IOException {

        final List<CategorySummaryModel> categorySummaryModels = this.categoryRepository.getCategorySummary()
                .stream()
                .map(c -> MODEL_MAPPER.map(c, CategorySummaryModel.class))
                .toList();
        writeIntoJsonFile(categorySummaryModels, THIRD_JSON_PATH);

        return categorySummaryModels;
    }
}
