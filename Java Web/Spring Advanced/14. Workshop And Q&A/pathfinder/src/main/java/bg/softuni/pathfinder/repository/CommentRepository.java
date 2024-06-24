package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT route_id, COUNT(id) FROM comments\n" +
            "GROUP BY route_id\n" +
            "ORDER BY COUNT(id) DESC\n" +
            "LIMIT 1", nativeQuery = true)
    Long getMostCommentedRouteId();
}
