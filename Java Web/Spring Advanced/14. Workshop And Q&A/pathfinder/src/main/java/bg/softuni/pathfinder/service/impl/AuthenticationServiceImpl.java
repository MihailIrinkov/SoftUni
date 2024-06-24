package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.dto.binding.UserRegisterBindingModel;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.enums.Level;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.AuthenticationService;
import bg.softuni.pathfinder.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;


    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        user.setLevel(Level.BEGINNER);
        user.setRoles(Set.of(roleService.getRoleByName("USER")));

        userRepository.save(user);
    }

}
