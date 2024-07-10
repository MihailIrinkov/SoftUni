package com.softuni.battleships.init;

import com.softuni.battleships.model.entity.Category;
import com.softuni.battleships.model.entity.enums.CategoryType;
import com.softuni.battleships.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SeedCategories implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public SeedCategories(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (categoryRepository.count() == 0) {

            List<Category> categories = new ArrayList<>();

            Arrays.stream(CategoryType.values())
                    .forEach(categoryType -> {
                        Category category = new Category();
                        category.setName(categoryType);
                        categories.add(category);
                    });

            this.categoryRepository.saveAll(categories);
        }

    }
}
