package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.dto.binding.UserLoginBindingModel;
import bg.softuni.pathfinder.model.dto.binding.UserRegisterBindingModel;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.model.enums.Level;
import bg.softuni.pathfinder.repository.RoleRepository;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.AuthenticationService;
import bg.softuni.pathfinder.service.RoleService;
import bg.softuni.pathfinder.service.session.LoggedUser;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    private final RoleService roleService;
    private final LoggedUser loggedUser;

    public AuthenticationServiceImpl(UserRepository userRepository,
                                     ModelMapper modelMapper,
                                     PasswordEncoder passwordEncoder, RoleService roleService, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.loggedUser = loggedUser;
    }

    @Override
    public void register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = modelMapper.map(userRegisterBindingModel, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        user.setLevel(Level.BEGINNER);
        user.setRoles(Set.of(roleService.getRoleByName("USER")));

        userRepository.save(user);
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();

        User user = this.userRepository.findByUsername(username).get();

        if (user == null) {
            throw new IllegalArgumentException("User with username: " + username + " not present");
        }

        boolean passwordMatch = passwordEncoder.matches(
                userLoginBindingModel.getPassword(), user.getPassword());

        if(!passwordMatch) {
            throw new IllegalArgumentException("User entered incorrect password");
        }

        loggedUser.setUsername(user.getUsername());
        loggedUser.setEmail(user.getEmail());
        loggedUser.setFullName(user.getFullName());
        loggedUser.setLogged(true);

        return passwordMatch;
    }

    @Override
    public void logout() {
        loggedUser.reset();
    }
}
