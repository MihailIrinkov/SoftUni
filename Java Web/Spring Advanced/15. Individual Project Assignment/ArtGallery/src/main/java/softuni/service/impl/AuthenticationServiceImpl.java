package softuni.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import softuni.model.dto.binding.UserRegisterBindingModel;
import softuni.model.entity.User;
import softuni.repository.UserRepository;
import softuni.service.AuthenticationService;
import softuni.service.RoleService;

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
        user.setRoles(Set.of(roleService.getRoleByName("USER")));

        userRepository.save(user);
    }

}
