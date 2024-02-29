package com.likebookapp.service;

import com.likebookapp.model.dto.user.UserLoginBindingModel;
import com.likebookapp.model.dto.user.UserRegisterBindingModel;

public interface UserService {

    boolean login(UserLoginBindingModel userLoginBindingModel);

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    void logout();

    UserRegisterBindingModel findUserByEmail(String value);

    UserRegisterBindingModel findUserByUsername(String value);
}
