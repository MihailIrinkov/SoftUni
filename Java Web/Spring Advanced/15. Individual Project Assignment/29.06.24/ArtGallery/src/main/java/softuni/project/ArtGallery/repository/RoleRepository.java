package softuni.project.ArtGallery.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.ArtGallery.model.entity.Role;
import softuni.project.ArtGallery.model.enums.UserRoles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(UserRoles role);
}
