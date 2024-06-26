package softuni.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.model.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT artist, COUNT(id) FROM comments\n" +
            "GROUP BY artist_id\n" +
            "ORDER BY COUNT(id) DESC\n" +
            "LIMIT 1", nativeQuery = true)
    Long getMostCommentedRouteId();
}
