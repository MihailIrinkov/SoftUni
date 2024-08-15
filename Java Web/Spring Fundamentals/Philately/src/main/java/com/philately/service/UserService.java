package com.philately.service;

import com.philately.model.dto.StampDTO;
import com.philately.model.dto.UserLoginBindingModel;
import com.philately.model.dto.UserRegisterBindingModel;

import java.util.List;
import java.util.Set;

public interface UserService {

    boolean register(UserRegisterBindingModel userRegisterBindingModel);

    boolean login(UserLoginBindingModel userLoginBindingModel);

    void logout();

    void removeFromWishList(Long id);

    void  buyStamp(String username);
}
