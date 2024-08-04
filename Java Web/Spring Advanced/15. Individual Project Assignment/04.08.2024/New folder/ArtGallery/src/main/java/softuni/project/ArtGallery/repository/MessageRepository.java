package softuni.project.ArtGallery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.ArtGallery.model.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
