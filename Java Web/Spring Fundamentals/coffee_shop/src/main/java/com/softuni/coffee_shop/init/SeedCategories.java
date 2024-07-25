package com.softuni.coffee_shop.init;

import com.softuni.coffee_shop.entity.Category;
import com.softuni.coffee_shop.entity.CategoryName;
import com.softuni.coffee_shop.repository.CategoryRepository;
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

        if (this.categoryRepository.count() == 0) {

            List<Category> categories = new ArrayList<>();

            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        Category category = new Category()
                                .setName(categoryName);
                        if (categoryName.equals(CategoryName.Cake)) {
                            category.setNeededTime(10);
                        } else if (categoryName.equals(CategoryName.Coffee)) {
                            category.setNeededTime(2);
                        } else if (categoryName.equals(CategoryName.Other)) {
                            category.setNeededTime(5);
                        } else if (categoryName.equals(CategoryName.Drink)) {
                            category.setNeededTime(1);
                        }

                        categories.add(category);
                    });
            this.categoryRepository.saveAll(categories);
        }

    }
}
