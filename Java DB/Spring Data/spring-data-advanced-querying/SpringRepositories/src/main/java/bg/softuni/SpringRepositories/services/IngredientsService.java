package bg.softuni.SpringRepositories.services;

import bg.softuni.SpringRepositories.entities.Ingredient;
import bg.softuni.SpringRepositories.entities.Shampoo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface IngredientsService {

    List<Ingredient> findAllByNameStartingWith(String letter);

    List<Ingredient> findAllNameIn(List<String> names);

    void deleteByName(String name);

    void deleteByName2(String name);

    void updatePriceAllByTenPercent(BigDecimal percent);

    void updateIngredientsByName(BigDecimal percent, Set<String> name);
}
