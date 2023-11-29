package softuni.bg.exerciseJSONprocessing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.bg.exerciseJSONprocessing.domain.entities.Category;
import softuni.bg.exerciseJSONprocessing.domain.models.category.CategorySummaryModel;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query(value = "SELECT * FROM `json-xml-exercise`.categories \n" +
            "ORDER BY RAND() LIMIT 1;", nativeQuery = true)
    Optional<Category> getRandomEntity();

    @Query(value = "SELECT new softuni.bg.exerciseJSONprocessing.domain.models.category.CategorySummaryModel(c.name, count(p.id), avg(p.price), sum(p.price))" +
            " FROM Product p " +
            "join p.categories" +
            " c group by c.id")
    List<CategorySummaryModel> getCategorySummary();

}
