package org.softuni.mobilele.service.impl;



import org.softuni.mobilele.model.dto.UserRegistrationDTO;
import org.softuni.mobilele.model.entity.UserEntity;
import org.softuni.mobilele.model.events.UserRegisteredEvent;
import org.softuni.mobilele.repository.UserRepository;
import org.softuni.mobilele.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final ApplicationEventPublisher appEventPublisher;
    private final UserDetailsService mobileleUserDetailsService;

    public UserServiceImpl(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            ApplicationEventPublisher appEventPublisher,
            UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.appEventPublisher = appEventPublisher;
        this.mobileleUserDetailsService = userDetailsService;
    }

    @Override
    public void registerUser(
            UserRegistrationDTO userRegistrationDTO) {

        userRepository.save(map(userRegistrationDTO));

        appEventPublisher.publishEvent(new UserRegisteredEvent(
                "UserService",
                userRegistrationDTO.getEmail(),
                userRegistrationDTO.fullName()
        ));
    }

    @Override
    public void createUserIfNotExist(String email, String names) {
        // Create manually a user in the database
        // password not necessary
    }

    @Override
    public Authentication login(String email) {
        UserDetails userDetails = mobileleUserDetailsService.loadUserByUsername(email);

        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );

        SecurityContextHolder.getContext().setAuthentication(auth);

        return auth;
    }

    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {
        return new UserEntity()
                .setActive(false)
                .setFirstName(userRegistrationDTO.getFirstName())
                .setLastName(userRegistrationDTO.getLastName())
                .setEmail(userRegistrationDTO.getEmail())
                .setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
    }


}


//import org.softuni.mobilele.model.dto.UserRegistrationDTO;
//import org.softuni.mobilele.model.entity.UserEntity;
//import org.softuni.mobilele.model.events.UserRegisteredEvent;
//import org.softuni.mobilele.repository.UserRepository;
//import org.softuni.mobilele.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserServiceImpl implements UserService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final ApplicationEventPublisher appEventPublisher;
//
//
//
//    @Autowired
//    public UserServiceImpl(UserRepository userRepository,
//                           PasswordEncoder passwordEncoder,
//                           ApplicationEventPublisher appEventPublisher) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.appEventPublisher = appEventPublisher;
//    }
//
//    @Override
//    public void registerUser(UserRegistrationDTO userRegistrationDto) {
//
//        userRepository.save(map(userRegistrationDto));
//
//        appEventPublisher.publishEvent(new UserRegisteredEvent(
//                "UserService",
//                userRegistrationDto.getEmail(),
//                userRegistrationDto.fullName()
//        ));
//    }
//
//
//    private UserEntity map(UserRegistrationDTO userRegistrationDto) {
//        UserEntity user = new UserEntity();
//
//        user.setActive(false);
//        user.setFirstName(userRegistrationDto.getFirstName());
//        user.setLastName(userRegistrationDto.getLastName());
//        user.setEmail(userRegistrationDto.getEmail());
//        user.setPassword(passwordEncoder
//                .encode(userRegistrationDto.getPassword()));
//
//        return user;
//    }
//}
