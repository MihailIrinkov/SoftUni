package com.softuni.gira.service;

import com.softuni.gira.model.dto.UserLoginBindingModel;
import com.softuni.gira.model.dto.UserRegisterBindingModel;

public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
