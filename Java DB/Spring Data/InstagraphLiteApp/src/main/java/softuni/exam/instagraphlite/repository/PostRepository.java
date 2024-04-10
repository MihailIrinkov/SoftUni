package softuni.exam.instagraphlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.instagraphlite.models.entity.Post;

import java.util.List;

//ToDo
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query(value = "SELECT user_id, COUNT(*) FROM posts GROUP BY user_id ORDER BY COUNT(user_id) DESC, user_id ASC;",
            nativeQuery = true)
    List<Long> findByPostCount();

    List<Post> findAllByUserIdOrderByPicture_Size(Long userId);
}
