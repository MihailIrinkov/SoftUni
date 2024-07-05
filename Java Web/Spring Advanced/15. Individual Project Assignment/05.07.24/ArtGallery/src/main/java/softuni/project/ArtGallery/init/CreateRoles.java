package softuni.project.ArtGallery.init;

import org.springframework.stereotype.Component;
import softuni.project.ArtGallery.model.entity.Role;
import softuni.project.ArtGallery.model.enums.UserRoles;
import softuni.project.ArtGallery.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

import static softuni.project.ArtGallery.model.enums.UserRoles.*;

@Component
public class CreateRoles {

    private final RoleRepository roleRepository;

    public CreateRoles(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    void generateUserRoles(RoleRepository repository) {
        if(this.roleRepository.count() == 0) {

            List<Role> roles = new ArrayList<>();

            Role admin = new Role();
            admin.setName(ADMIN);
            roles.add(admin);

            Role moderator = new Role();
            moderator.setName(MODERATOR);
            roles.add(moderator);

            Role user = new Role();
            user.setName(USER);
            roles.add(user);

            Role anonymous = new Role();
            anonymous.setName(ANONYMOUS);
            roles.add(anonymous);

            this.roleRepository.saveAll(roles);
        }
    }
}
