package bg.softuni.SpringRepositories.repositories;

import bg.softuni.SpringRepositories.entities.Ingredient;
import bg.softuni.SpringRepositories.entities.Shampoo;
import bg.softuni.SpringRepositories.entities.Size;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ShampooRepository extends JpaRepository<Shampoo, Long> {

    List<Shampoo> findAllBySizeOrderById(Size size);

    List<Shampoo> findAllBySizeOrLabelIdOrderByPrice(Size size, Long labelId);

    List<Shampoo> findAllByPriceGreaterThanOrderByPriceDesc(BigDecimal price);

    Integer countByPriceLessThan(BigDecimal price);

    @Query("SELECT s FROM Shampoo as s join s.ingredients AS i WHERE i.name IN :names")
    List<Shampoo> findAllWithIngredients(List<String> names);

    @Query("SELECT s FROM Shampoo AS s " +
            "WHERE size(s.ingredients) < :count")
    List<Shampoo> findByIngredientCountLessThan(int count);

}
