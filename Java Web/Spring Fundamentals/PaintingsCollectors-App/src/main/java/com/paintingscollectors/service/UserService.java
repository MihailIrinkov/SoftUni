package com.paintingscollectors.service;

import com.paintingscollectors.model.dto.UserLoginBindingModel;
import com.paintingscollectors.model.dto.UserRegisterBindingModel;

public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
