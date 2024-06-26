package softuni.project.ArtGallery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.ArtGallery.model.entity.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
