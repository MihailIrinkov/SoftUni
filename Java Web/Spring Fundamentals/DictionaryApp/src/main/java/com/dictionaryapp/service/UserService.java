package com.dictionaryapp.service;

import com.dictionaryapp.model.dto.LoginBindingModel;
import com.dictionaryapp.model.dto.UserRegisterBindingModel;

public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(LoginBindingModel loginBindingModel);

    void logout();
}
