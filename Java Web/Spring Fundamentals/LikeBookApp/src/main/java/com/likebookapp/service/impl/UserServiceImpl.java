package com.likebookapp.service.impl;

import com.likebookapp.model.dto.user.UserLoginBindingModel;
import com.likebookapp.model.dto.user.UserRegisterBindingModel;
import com.likebookapp.model.entity.User;
import com.likebookapp.repository.UserRepository;
import com.likebookapp.service.LoggedUser;
import com.likebookapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {
        String username = userLoginBindingModel.getUsername();

        User user = this.userRepository.findByUsername(username).orElse(null);

        if (user != null &&
                user.getPassword().equals(userLoginBindingModel.getPassword())) {
            loggedUser.login(username);
            return true;
        }

        return false;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        String username = userRegisterBindingModel.getUsername();
        String email = userRegisterBindingModel.getEmail();

        User userByUsername = this.userRepository.findByUsername(username).orElse(null);
        User userByEmAIL = this.userRepository.findByEmail(email).orElse(null);

        if (userByUsername == null && userByEmAIL == null
                && userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword())) {
            User userToSave = new User();
            userToSave.setUsername(username);
            userToSave.setEmail(email);
            userToSave.setPassword(userRegisterBindingModel.getPassword());

            this.userRepository.save(userToSave);
            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        loggedUser.logout();
    }

    @Override
    public UserRegisterBindingModel findUserByEmail(String value) {
        User user = this.userRepository.findByEmail(value).orElse(null);

        if (user == null) {
            return null;
        }

        return this.mapUserRegisterBindingModel(user);
    }

    @Override
    public UserRegisterBindingModel findUserByUsername(String value) {
        User userByUsername = this.userRepository.findByUsername(value).orElse(null);

        if (userByUsername == null) {
            return null;
        }

        return this.mapUserRegisterBindingModel(userByUsername);
    }

    private UserRegisterBindingModel mapUserRegisterBindingModel(User user) {
        UserRegisterBindingModel userRegisterBindingModel = new UserRegisterBindingModel();
        userRegisterBindingModel.setUsername(user.getUsername());
        userRegisterBindingModel.setEmail(userRegisterBindingModel.getEmail());
        userRegisterBindingModel.setPassword(userRegisterBindingModel.getPassword());

        return userRegisterBindingModel;
    }
}
