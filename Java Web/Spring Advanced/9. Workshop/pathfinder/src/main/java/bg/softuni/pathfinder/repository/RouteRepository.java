package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.Route;
import bg.softuni.pathfinder.model.enums.CategoryNames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findAllByCategories_Name(CategoryNames categoryName);
}
