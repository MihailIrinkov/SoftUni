package bg.softuni.example.springintro.service;

import bg.softuni.example.springintro.model.entity.Category;


import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
