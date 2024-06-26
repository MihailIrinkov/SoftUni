package softuni.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.model.entity.Role;
import softuni.model.enums.UserRoles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(UserRoles role);
}
