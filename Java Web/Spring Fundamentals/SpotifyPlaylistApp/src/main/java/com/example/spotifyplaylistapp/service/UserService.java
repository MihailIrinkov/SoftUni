package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.dto.UserLoginBindingModel;
import com.example.spotifyplaylistapp.model.entity.dto.UserRegisterBindingModel;

public interface UserService {

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();

    boolean register(UserRegisterBindingModel userRegisterBindingModel);
}
