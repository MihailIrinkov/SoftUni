package com.softuni.shopping_list.init;

import com.softuni.shopping_list.entity.Category;
import com.softuni.shopping_list.entity.CategoryName;
import org.springframework.boot.CommandLineRunner;
import com.softuni.shopping_list.repository.CategoryRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeedCategories implements CommandLineRunner {

    private final CategoryRepository categoryRepository;

    public SeedCategories(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.categoryRepository.count() == 0) {

            List<Category> categories = new ArrayList<>();

                    Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category();
                        category.setName(categoryName);
                        categories.add(category);
                    });

            this.categoryRepository.saveAll(categories);
        }

    }
}
