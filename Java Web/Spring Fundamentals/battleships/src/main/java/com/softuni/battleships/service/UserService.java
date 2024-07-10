package com.softuni.battleships.service;

import com.softuni.battleships.model.dto.user.UserLoginBindingModel;
import com.softuni.battleships.model.dto.user.UserRegisterBindingModel;


public interface UserService {
    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginDTO);

    void logout();
}
