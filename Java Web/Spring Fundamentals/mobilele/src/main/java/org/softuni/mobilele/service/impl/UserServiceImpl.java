package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.UserLoginDto;
import org.softuni.mobilele.model.dto.UserRegistrationDto;
import org.softuni.mobilele.model.entity.User;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.UserService;
import org.softuni.mobilele.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final CurrentUser currentUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {

        userRepository.save(map(userRegistrationDto));
    }

    @Override
    public boolean loginUser(UserLoginDto userLoginDto) {

        var user = userRepository
                .findAllByEmail(userLoginDto.getEmail())
                .orElse(null);

        boolean loginSuccess = false;

        if(user != null) {

            String rawPassword = userLoginDto.getPassword();
            String encodedPassword = user.getPassword();

            loginSuccess = encodedPassword != null
                    && passwordEncoder.matches(rawPassword, encodedPassword);


            if(loginSuccess) {
                currentUser.setLogged(true);
                currentUser.setFirstName(user.getFirstName());
                currentUser.setLastName(user.getLastName());
            } else {
                currentUser.logout();
            }

        }

        return loginSuccess;
    }

    @Override
    public void logoutUser() {
        currentUser.logout();
    }

    private User map(UserRegistrationDto userRegistrationDto) {
        User user = new User();

        user.setActive(true);
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder
                .encode(userRegistrationDto.getPassword()));

        return user;
    }
}
