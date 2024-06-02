package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.Role;
import bg.softuni.pathfinder.model.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(RoleType role);
}
