package softuni.project.ArtGallery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.ArtGallery.model.entity.Category;
import softuni.project.ArtGallery.model.enums.CategoryNames;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> findByNameIn(Set<CategoryNames> categories);
}
