package com.softuni.music_db_application.service.impl;

import com.softuni.music_db_application.model.dto.UserLoginBindingModel;
import com.softuni.music_db_application.model.dto.UserRegisterBindingModel;
import com.softuni.music_db_application.model.entity.User;
import com.softuni.music_db_application.repository.UserRepository;
import com.softuni.music_db_application.service.LoggedUser;
import com.softuni.music_db_application.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository,
                           LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {

        Optional<User> userByUsernameOrEmail =
                this.userRepository.findByUsernameOrEmail(
                        userRegisterBindingModel.getUsername(),
                        userRegisterBindingModel.getEmail());

        if (userByUsernameOrEmail.isPresent()) {
            return false;
        }

        if (!userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }

        User userToSave = new User()
                .setUsername(userRegisterBindingModel.getUsername())
                .setFullName(userRegisterBindingModel.getFullName())
                .setEmail(userRegisterBindingModel.getEmail())
                .setPassword(userRegisterBindingModel.getPassword());

        this.userRepository.save(userToSave);

        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {

        Optional<User> user = this.userRepository.findByUsername(userLoginBindingModel.getUsername());

        if (user.isPresent() &&
        userLoginBindingModel.getPassword().equals(user.get().getPassword())) {

            loggedUser.login(userLoginBindingModel.getUsername());

            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        loggedUser.logout();
    }

}
