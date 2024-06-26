package softuni.service.impl;


import org.springframework.stereotype.Service;
import softuni.model.entity.Role;
import softuni.model.enums.UserRoles;
import softuni.repository.RoleRepository;
import softuni.service.RoleService;

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
