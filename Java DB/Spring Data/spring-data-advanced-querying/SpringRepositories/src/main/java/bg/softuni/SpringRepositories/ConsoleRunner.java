package bg.softuni.SpringRepositories;

import bg.softuni.SpringRepositories.entities.Ingredient;
import bg.softuni.SpringRepositories.entities.Shampoo;
import bg.softuni.SpringRepositories.services.IngredientsService;
import bg.softuni.SpringRepositories.services.ShampooService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final ShampooService shampooService;
    private final IngredientsService ingredientsService;

    public ConsoleRunner(ShampooService shampooService, IngredientsService ingredientsService) {
        this.shampooService = shampooService;
        this.ingredientsService = ingredientsService;
    }

    @Override
    public void run(String... args) throws Exception {

        // 1. Select Shampoos by Size
//        this.shampooService.findShampoosBySizeOrderById(Size.MEDIUM).stream()
//                .map(shampoo -> {
//                    System.out.println(String.format("%s %s %slv." ,shampoo.getBrand(), shampoo.getSize(), shampoo.getPrice()));
//                    return shampoo.getId();
//                }).toList();


        // 2. Select Shampoos by Size or Label
//        this.shampooService.findAllBySizeOrLabelId(Size.MEDIUM, 10L).stream()
//                .map(shampoo -> {
//                    System.out.println(String.format("%s %s %slv." ,shampoo.getBrand(), shampoo.getSize(), shampoo.getPrice()));
//                    return shampoo.getId();
//                }).toList();

        // 3. Select Shampoos by Price

//        this.shampooService.findAllByPriceGreaterThanDesc(BigDecimal.valueOf(5)).stream()
//                .map(shampoo -> {
//                    System.out.println(String.format("%s %s %slv." ,shampoo.getBrand(), shampoo.getSize(), shampoo.getPrice()));
//                    return shampoo.getId();
//                }).toList();

        // 4. Select Ingredients by Name
//        this.ingredientsService.findAllByNameStartingWith("M")
//                .stream()
//                .map(ingredient -> {
//                    System.out.println(String.format("%s", ingredient.getName()));
//                    return ingredient.getName();
//                }).toList();

        // 5. Select Ingredients by Names
//        this.ingredientsService.findAllNameIn(List.of("Lavender", "Herbs", "Apple"))
//                .stream()
//                .map(ingredient -> {
//                    System.out.println(ingredient.getName());
//                    return ingredient.getName();
//                }).toList();


        // 6. Count Shampoos by Price
        //System.out.println(this.shampooService.countByPriceLessThan(BigDecimal.valueOf(8.50)));

        // JPQL Querying 7. Select Shampoos by Ingredients
//        this.shampooService.findAllWithIngredients(List.of("Berry", "Mineral-Collagen"))
//                .stream()
//                .map(s -> {
//                    System.out.println(s.getBrand());
//                    return s.getBrand();
//                }).toList();

        // 8. Select Shampoos by Ingredients Count

//        final List<Shampoo> result =
//                this.shampooService.getAllWithIngredientsCountLessThen(2).stream().toList();
//
//        for (Shampoo s : result) {
//            System.out.println(s.getBrand());
//        }


       // 9.	Delete Ingredients by Nam

//        this.ingredientsService.deleteByName2("Active-Caffeine");

        // 10.	Update Ingredients by Price

//        BigDecimal percentValue = BigDecimal.valueOf(1.1);
//        this.ingredientsService.updatePriceAllByTenPercent(percentValue);


        // 11. Update Ingredients by Names

        Set<String> ingredients = new HashSet<>();
        ingredients.add("Apple");
        ingredients.add("Berry");

        BigDecimal percentValue = BigDecimal.valueOf(1.1);
        this.ingredientsService.updateIngredientsByName(percentValue, ingredients);
    }
}
