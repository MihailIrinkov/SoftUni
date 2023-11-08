package bg.softuni.SpringRepositories.services;

import bg.softuni.SpringRepositories.entities.Shampoo;
import bg.softuni.SpringRepositories.entities.Size;

import java.math.BigDecimal;
import java.util.List;

public interface ShampooService {
    List<Shampoo> findShampoosBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelId(Size size, Long id);

    List<Shampoo> findAllByPriceGreaterThanDesc(BigDecimal price);

    Integer countByPriceLessThan(BigDecimal price);

    List<Shampoo> findAllWithIngredients(List<String> names);

    List<Shampoo> getAllWithIngredientsCountLessThen(int count);

}
