package com.softuni.music_db_application.controller;

import com.softuni.music_db_application.model.dto.UserLoginBindingModel;
import com.softuni.music_db_application.model.dto.UserRegisterBindingModel;
import com.softuni.music_db_application.service.LoggedUser;
import com.softuni.music_db_application.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final LoggedUser loggedUser;
    private final UserService userService;

    public UserController(LoggedUser loggedUser,
                          UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login(
            @ModelAttribute("userLoginBindingModel")
            UserLoginBindingModel userLoginBindingModel
    ) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("/login");
    }


    @PostMapping("login")
    public ModelAndView login(
            @ModelAttribute("userLoginBindingModel") @Valid
            UserLoginBindingModel userLoginBindingModel,
            BindingResult bindingResult
    ) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("login");
        }

        boolean hasSuccessfulLogin = this.userService.login(userLoginBindingModel);

        if (!hasSuccessfulLogin) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasLoginError", true);

            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/logout")
    public ModelAndView logout() {
        this.userService.logout();

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("redirect:/");
    }

    @GetMapping("/register")
    public ModelAndView register(
            @ModelAttribute("userRegisterBindingModel")
            UserRegisterBindingModel userRegisterBindingModel
    ) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("/register");
    }

    @PostMapping("/register")
    public ModelAndView register(
            @ModelAttribute("userRegisterBindingModel") @Valid
            UserRegisterBindingModel userRegisterBindingModel,
            BindingResult bindingResult
    ) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }

        boolean hasSuccessfulRegister = this.userService.register(userRegisterBindingModel);

        if (!hasSuccessfulRegister) {
            ModelAndView modelAndView = new ModelAndView("register");
            modelAndView.addObject("hasRegisterError", true);

            return modelAndView;
        }

        return new ModelAndView("redirect:/login");
    }
}
