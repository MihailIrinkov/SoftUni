package com.paintingscollectors.service.impl;

import com.paintingscollectors.model.dto.UserLoginBindingModel;
import com.paintingscollectors.model.dto.UserRegisterBindingModel;
import com.paintingscollectors.model.entity.User;
import com.paintingscollectors.repository.UserRepository;
import com.paintingscollectors.service.LoggedUser;
import com.paintingscollectors.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final LoggedUser loggedUser;

    @Override
    public void logout() {
        this.loggedUser.logout();
    }

    private final UserRepository userRepository;

    public UserServiceImpl(LoggedUser loggedUser,
                           UserRepository userRepository) {
        this.loggedUser = loggedUser;
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {

        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(userRegisterBindingModel.getUsername());
        Optional<User> byEmail = this.userRepository.findByEmail(userRegisterBindingModel.getEmail());

        if (byEmail.isPresent() || byUsername.isPresent()) {
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

        Optional<User> byUsername = this.userRepository.findByUsername(userLoginBindingModel.getUsername());

        if (byUsername.isEmpty() ||
                !byUsername.get().getPassword().equals(userLoginBindingModel.getPassword())) {
            return false;
        }

        loggedUser.login(userLoginBindingModel.getUsername());

        return true;
    }
}
