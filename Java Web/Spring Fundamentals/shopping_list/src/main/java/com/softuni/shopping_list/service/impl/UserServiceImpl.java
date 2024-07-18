package com.softuni.shopping_list.service.impl;

import com.softuni.shopping_list.entity.User;
import com.softuni.shopping_list.entity.dto.UserLoginBindingModel;
import com.softuni.shopping_list.entity.dto.UserRegistrationBindingModel;
import com.softuni.shopping_list.repository.UserRepository;
import com.softuni.shopping_list.service.LoggedUser;
import com.softuni.shopping_list.service.UserService;
import org.aspectj.apache.bcel.classfile.Module;
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
    public boolean register(UserRegistrationBindingModel userRegistrationBindingModel) {

        if (!userRegistrationBindingModel.getPassword().equals(userRegistrationBindingModel.getConfirmPassword())) {
            return false;
        }

        Optional<User> byUsername = this.userRepository.findByUsername(userRegistrationBindingModel.getUsername());
        Optional<User> byEmail = this.userRepository.findByEmail(userRegistrationBindingModel.getEmail());

        if (byUsername.isPresent() || byEmail.isPresent()) {
            return false;
        }

        User userToSave = new User()
                .setUsername(userRegistrationBindingModel.getUsername())
                .setEmail(userRegistrationBindingModel.getEmail())
                .setPassword(userRegistrationBindingModel.getPassword());

        this.userRepository.save(userToSave);

        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {

        Optional<User> user = this.userRepository.findByUsername(userLoginBindingModel.getUsername());

        if (user.isPresent() && user.get().getPassword().equals(userLoginBindingModel.getPassword())) {
            loggedUser.login(userLoginBindingModel.getUsername());
            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }
}
