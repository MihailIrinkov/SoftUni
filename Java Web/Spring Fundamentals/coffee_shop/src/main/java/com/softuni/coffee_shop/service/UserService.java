package com.softuni.coffee_shop.service;

import com.softuni.coffee_shop.entity.dto.UserLoginBindingModel;
import com.softuni.coffee_shop.entity.dto.UserRegisterBindingModel;

public interface UserService {

    boolean register(UserRegisterBindingModel registerBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
