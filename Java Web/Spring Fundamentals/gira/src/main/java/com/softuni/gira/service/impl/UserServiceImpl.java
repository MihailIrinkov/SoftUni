package com.softuni.gira.service.impl;

import com.softuni.gira.model.dto.UserLoginBindingModel;
import com.softuni.gira.model.dto.UserRegisterBindingModel;
import com.softuni.gira.model.entity.User;
import com.softuni.gira.repository.UserRepository;
import com.softuni.gira.service.LoggedUser;
import com.softuni.gira.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final LoggedUser loggedUser;
    private final UserRepository userRepository;

    public UserServiceImpl(LoggedUser loggedUser,
                           UserRepository userRepository) {
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {

        if (!userRegisterBindingModel.getPassword().equals(
                userRegisterBindingModel.getConfirmPassword()
        )) {
            return false;
        }

        Optional<User> byUsername = this.userRepository
                .findByUsername(userRegisterBindingModel.getUsername());
        Optional<User> byEmail = this.userRepository
                .findByEmail(userRegisterBindingModel.getEmail());


        if (byUsername.isPresent() || byEmail.isPresent()) {
            return false;
        }

        User userToSave = new User()
                .setUsername(userRegisterBindingModel.getUsername())
                .setEmail(userRegisterBindingModel.getEmail())
                .setPassword(userRegisterBindingModel.getPassword());

        this.userRepository.save(userToSave);

        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {

        Optional<User> user = this.userRepository.findByEmail(userLoginBindingModel.getEmail());

        if (user.isEmpty() || !user.get().getPassword().equals(
                userLoginBindingModel.getPassword())) {
            return false;
        }

        loggedUser.login(user.get().getUsername());

        return true;
    }

    @Override
    public void logout() {
        loggedUser.logout();
    }
}
