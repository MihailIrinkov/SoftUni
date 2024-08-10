package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.LoginBindingModel;
import com.dictionaryapp.model.dto.UserRegisterBindingModel;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.UserService;
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
    public boolean login(LoginBindingModel loginBindingModel) {

        Optional<User> byUsername = this.userRepository.findByUsername(loginBindingModel.getUsername());

        if (byUsername.isPresent() && byUsername.get().getPassword()
                .equals(loginBindingModel.getPassword())) {
            loggedUser.login(loginBindingModel.getUsername());
            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        loggedUser.logout();
    }
}
