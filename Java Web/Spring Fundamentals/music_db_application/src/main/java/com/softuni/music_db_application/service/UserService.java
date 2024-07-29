package com.softuni.music_db_application.service;

import com.softuni.music_db_application.model.dto.UserLoginBindingModel;
import com.softuni.music_db_application.model.dto.UserRegisterBindingModel;

public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();

}
