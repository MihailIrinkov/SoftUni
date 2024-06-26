package softuni.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.model.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
}
