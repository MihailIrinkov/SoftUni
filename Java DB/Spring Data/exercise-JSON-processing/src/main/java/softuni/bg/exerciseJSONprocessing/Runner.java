package softuni.bg.exerciseJSONprocessing;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.bg.exerciseJSONprocessing.services.category.CategoryService;
import softuni.bg.exerciseJSONprocessing.services.product.ProductService;
import softuni.bg.exerciseJSONprocessing.services.seed.SeedService;
import softuni.bg.exerciseJSONprocessing.services.user.UserService;

import java.math.BigDecimal;

@Component
public class Runner implements CommandLineRunner {
    private final SeedService seedService;
    private final ProductService productService;

    private final UserService userService;

    private final CategoryService categoryService;

    public Runner(SeedService seedService, ProductService productService, UserService userService, CategoryService categoryService) {
        this.seedService = seedService;
        this.productService = productService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {

        this.seedService.seedAll("XML");

        this.productService
                .getProductsInRangeWithNoBuyer(BigDecimal.valueOf(500), BigDecimal.valueOf(1000));

        this.userService.getUsersWithSoldProducts();

        this.categoryService.findCategorySummary();

        this.userService.getUsersWithSoldProducts2();

    }
}
