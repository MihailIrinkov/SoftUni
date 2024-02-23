package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.dto.user.UserLoginBindingModel;
import com.dictionaryapp.model.dto.user.UserRegisterBindingModel;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.UserService;
import org.springframework.stereotype.Service;

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
        User user = this.userRepository.findAllByUsername(username);

        if (user != null &&
                userLoginBindingModel.getPassword().equals(user.getPassword())) {
            loggedUser.login(username);
            return true;
        }

        return false;
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {
        User user = this.userRepository.findByEmailAndUsername(
                userRegisterBindingModel.getEmail(), userRegisterBindingModel.getUsername());

        if (user == null &&
                userRegisterBindingModel.getPassword().equals(
                        userRegisterBindingModel.getConfirmPassword())) {
            User userToSave = new User();

            userToSave.setUsername(userRegisterBindingModel.getUsername());
            userToSave.setEmail(userRegisterBindingModel.getEmail());
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

    private UserRegisterBindingModel mapUserRegisterBindingModel(User user) {
        UserRegisterBindingModel userRegisterBindingModel = new UserRegisterBindingModel();
        userRegisterBindingModel.setUsername(user.getUsername());
        userRegisterBindingModel.setEmail(user.getEmail());
        userRegisterBindingModel.setPassword(user.getPassword());

        return userRegisterBindingModel;
    }

    public UserRegisterBindingModel findUserByUsername(String value) {
        User user = this.userRepository.findAllByUsername(value);

        if (user == null) {
            return null;
        }

        return this.mapUserRegisterBindingModel(user);
    }
}
