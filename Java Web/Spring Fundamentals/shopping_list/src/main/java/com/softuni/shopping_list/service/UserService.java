package com.softuni.shopping_list.service;

import com.softuni.shopping_list.entity.dto.UserLoginBindingModel;
import com.softuni.shopping_list.entity.dto.UserRegistrationBindingModel;

public interface UserService {

    boolean register(UserRegistrationBindingModel userRegistrationBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();
}
