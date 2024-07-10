package com.softuni.battleships.service.impl;

import com.softuni.battleships.model.dto.user.UserLoginBindingModel;
import com.softuni.battleships.model.dto.user.UserRegisterBindingModel;
import com.softuni.battleships.model.entity.User;
import com.softuni.battleships.repository.UserRepository;
import com.softuni.battleships.service.LoggedUser;
import com.softuni.battleships.service.UserService;
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

        Optional<User> user = this.userRepository.findAllByUsernameAndAndEmail(
                userRegisterBindingModel.getUsername(), userRegisterBindingModel.getEmail()
        );

        if (user.isPresent() || !userRegisterBindingModel.getPassword().equals(
                userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }

        User userToSave = new User();
        userToSave.setUsername(userRegisterBindingModel.getUsername());
        userToSave.setFullName(userRegisterBindingModel.getFullName());
        userToSave.setEmail(userRegisterBindingModel.getEmail());
        userToSave.setPassword(userRegisterBindingModel.getPassword());

        this.userRepository.save(userToSave);
        return true;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginDTO) {

        Optional<User> optionalUser =
                userRepository.findAllByUsername(userLoginDTO.getUsername());

        if (optionalUser.isPresent() &&
                optionalUser.get().getPassword().equals(userLoginDTO.getPassword())) {
            loggedUser.login(optionalUser.get().getId());
            return true;
        }


        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }
}
