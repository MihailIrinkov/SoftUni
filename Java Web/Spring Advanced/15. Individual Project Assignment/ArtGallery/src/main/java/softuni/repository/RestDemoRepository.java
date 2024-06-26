package softuni.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.model.entity.User;

@Repository
public interface RestDemoRepository extends JpaRepository<User, Long> {
}
