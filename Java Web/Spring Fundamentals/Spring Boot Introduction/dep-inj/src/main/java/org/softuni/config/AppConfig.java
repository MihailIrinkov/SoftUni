package org.softuni.config;

import org.softuni.repository.InMemoryUserRepository;
import org.softuni.repository.UserRepository;
import org.softuni.service.UserService;
import org.softuni.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserServiceImpl(userRepository);
    }

}
