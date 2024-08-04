package softuni.project.ArtGallery.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.project.ArtGallery.model.dto.binding.UserRegisterBindingModel;
import softuni.project.ArtGallery.model.entity.User;
import softuni.project.ArtGallery.repository.UserRepository;
import softuni.project.ArtGallery.service.AuthenticationService;
import softuni.project.ArtGallery.service.RoleService;

import java.util.Optional;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;


    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {

        Optional<User> optionalUser = this.userRepository.findByUsername(userRegisterBindingModel.getUsername());

        if (optionalUser.isPresent()) {
            return false;
        }

        User user = modelMapper.map(userRegisterBindingModel, User.class);
        user.setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        user.setRoles(Set.of(roleService.getRoleByName("USER")));

        System.out.println();

        userRepository.save(user);

        return true;
    }

}
