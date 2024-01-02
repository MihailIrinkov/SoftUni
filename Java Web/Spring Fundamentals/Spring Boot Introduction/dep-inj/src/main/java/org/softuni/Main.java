package org.softuni;

import org.softuni.config.AppConfig;
import org.softuni.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        System.out.println(userService.findYoungestUser().orElseThrow());
    }
}