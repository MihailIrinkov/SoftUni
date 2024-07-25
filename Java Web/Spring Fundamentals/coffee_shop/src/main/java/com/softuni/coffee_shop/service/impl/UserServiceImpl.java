package com.softuni.coffee_shop.service.impl;

import com.softuni.coffee_shop.entity.User;
import com.softuni.coffee_shop.entity.dto.UserLoginBindingModel;
import com.softuni.coffee_shop.entity.dto.UserRegisterBindingModel;
import com.softuni.coffee_shop.repository.UserRepository;
import com.softuni.coffee_shop.service.LoggedUser;
import com.softuni.coffee_shop.service.UserService;
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
    public boolean register(UserRegisterBindingModel registerBindingModel) {

        if (!registerBindingModel.getPassword().equals(registerBindingModel.getConfirmPassword())) {
            return false;
        }

        Optional<User> byUsername =
                this.userRepository.findByUsername(registerBindingModel.getUsername());

        Optional<User> byEmail =
                this.userRepository.findByEmail(registerBindingModel.getEmail());

        if (byUsername.isEmpty() && byEmail.isEmpty()) {

            User userToSave = new User()
                    .setUsername(registerBindingModel.getUsername())
                    .setFirstName(registerBindingModel.getFirstName())
                    .setLastName(registerBindingModel.getLastName())
                    .setPassword(registerBindingModel.getPassword())
                    .setEmail(registerBindingModel.getEmail());

            this.userRepository.save(userToSave);

            return true;
        }

        return false;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {

        Optional<User> byUsername = this.userRepository.findByUsername(userLoginBindingModel.getUsername());

        if (byUsername.isPresent() &&
        userLoginBindingModel.getPassword().equals(byUsername.get().getPassword())) {
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
