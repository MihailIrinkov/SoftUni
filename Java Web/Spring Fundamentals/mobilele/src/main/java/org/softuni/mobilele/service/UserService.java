package org.softuni.mobilele.service;

import org.softuni.mobilele.model.dto.UserLoginDto;
import org.softuni.mobilele.model.dto.UserRegistrationDto;

public interface UserService {

    void registerUser(UserRegistrationDto userRegistrationDto);

    boolean loginUser(UserLoginDto userLoginDto);

    void logoutUser();
}
