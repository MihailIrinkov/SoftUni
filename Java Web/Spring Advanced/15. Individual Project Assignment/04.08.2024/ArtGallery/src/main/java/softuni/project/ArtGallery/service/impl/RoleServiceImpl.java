package softuni.project.ArtGallery.service.impl;


import org.springframework.stereotype.Service;
import softuni.project.ArtGallery.model.entity.Role;
import softuni.project.ArtGallery.model.enums.UserRoles;
import softuni.project.ArtGallery.repository.RoleRepository;
import softuni.project.ArtGallery.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleByName(String name) {
        return this.roleRepository.findByName(UserRoles.valueOf(name));
    }
}
