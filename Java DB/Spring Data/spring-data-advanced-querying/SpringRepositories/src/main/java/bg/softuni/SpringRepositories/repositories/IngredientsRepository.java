package bg.softuni.SpringRepositories.repositories;

import bg.softuni.SpringRepositories.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredient, Long> {

    List<Ingredient> findAllByNameStartingWith(String letter);

    List<Ingredient> findAllByNameIn(List<String> names);

    @Modifying
    void deleteByName(String name);

//    @Query("DELETE i FROM ingredient AS i WHERE i.name = :name")
//    @Modifying
//    void deleteByName2(String name);

    @Query("DELETE FROM Ingredient AS i WHERE i.name = name")
    @Modifying
    void deleteByName2(String name);

//    @Query("UPDATE i FROM Ingredient AS i SET i.price = i.price * 1.10")
//    @Modifying
@Query("UPDATE Ingredient AS i " +
        "SET i.price = i.price * :percent")
@Modifying
    void updateAllPrice(BigDecimal percent);

@Query("UPDATE Ingredient AS i SET i.price = i.price * :percent WHERE i.name IN :names")
@Modifying
void updateIngredientsByName(BigDecimal percent, Set<String> names);
}
