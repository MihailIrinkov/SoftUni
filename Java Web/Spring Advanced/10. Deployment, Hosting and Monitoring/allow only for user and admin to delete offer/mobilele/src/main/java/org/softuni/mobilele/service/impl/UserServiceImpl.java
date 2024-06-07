package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.dto.UserRegistrationDto;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.model.events.UserRegisteredEvent;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApplicationEventPublisher appEventPublisher;



    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           ApplicationEventPublisher appEventPublisher) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.appEventPublisher = appEventPublisher;
    }

    @Override
    public void registerUser(UserRegistrationDto userRegistrationDto) {

        userRepository.save(map(userRegistrationDto));

        appEventPublisher.publishEvent(new UserRegisteredEvent(
                "UserService",
                userRegistrationDto.getEmail(),
                userRegistrationDto.fullName()
        ));
    }


    private UserEntity map(UserRegistrationDto userRegistrationDto) {
        UserEntity user = new UserEntity();

        user.setActive(false);
        user.setFirstName(userRegistrationDto.getFirstName());
        user.setLastName(userRegistrationDto.getLastName());
        user.setEmail(userRegistrationDto.getEmail());
        user.setPassword(passwordEncoder
                .encode(userRegistrationDto.getPassword()));

        return user;
    }
}
