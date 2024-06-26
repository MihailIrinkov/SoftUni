package softuni.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.model.entity.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture, Long> {
}
