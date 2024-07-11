package com.example.spotifyplaylistapp.service.impl;

import com.example.spotifyplaylistapp.model.entity.User;
import com.example.spotifyplaylistapp.model.entity.dto.UserLoginBindingModel;
import com.example.spotifyplaylistapp.model.entity.dto.UserRegisterBindingModel;
import com.example.spotifyplaylistapp.repository.UserRepo;
import com.example.spotifyplaylistapp.service.LoggedUser;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final LoggedUser loggedUser;

    public UserServiceImpl(UserRepo userRepo,
                           LoggedUser loggedUser) {
        this.userRepo = userRepo;
        this.loggedUser = loggedUser;
    }

    @Override
    public boolean login(UserLoginBindingModel userLoginBindingModel) {

        Optional<User> optionalUser = this.userRepo
                .findByUsernameAndPassword(userLoginBindingModel.getUsername(),
                        userLoginBindingModel.getPassword());

        if (optionalUser.isPresent()) {
            loggedUser.login(optionalUser.get().getUsername());
            loggedUser.setLogged(true);
            return true;
        }

        return false;
    }

    @Override
    public void logout() {
        this.loggedUser.logout();
    }

    @Override
    public boolean register(UserRegisterBindingModel userRegisterBindingModel) {

        if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
            return false;
        }

        Optional<User> optionalUserByUsername =this.userRepo.findByUsername(userRegisterBindingModel.getUsername());
        Optional<User> optionalUserByEmail =this.userRepo.findByEmail(userRegisterBindingModel.getEmail());

        if (optionalUserByUsername.isEmpty() && optionalUserByEmail.isEmpty()) {

            User userToSave = new User()
                    .setUsername(userRegisterBindingModel.getUsername())
                    .setPassword(userRegisterBindingModel.getPassword())
                    .setEmail(userRegisterBindingModel.getEmail());
            this.userRepo.save(userToSave);

            return true;
        }

        return false;
    }


}
