package softuni.project.ArtGallery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.ArtGallery.model.entity.Artist;
import softuni.project.ArtGallery.model.enums.CategoryNames;

import java.util.List;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findAllByCategories_Name(CategoryNames categoryName);
}
