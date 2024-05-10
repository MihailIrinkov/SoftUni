package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.Category;
import bg.softuni.pathfinder.model.enums.CategoryName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> findByNameIn(Set<CategoryName> categories);
}
