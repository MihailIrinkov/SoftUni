package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.user.UserLoginBindingModel;
import com.dictionaryapp.model.dto.user.UserRegisterBindingModel;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;
    private final LoggedUser loggedUser;

    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/login")
    public ModelAndView login(@ModelAttribute("userLoginBindingModel")
                              UserLoginBindingModel userLoginBindingModel) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(
            @ModelAttribute("userLoginBindingModel")
            @Valid UserLoginBindingModel userLoginBindingModel,
            BindingResult bindingResult) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("login");
        }

        boolean successfulLogin = userService.login(userLoginBindingModel);

        if (!successfulLogin) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasLoginError", true);
            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/register")
    public ModelAndView register(
            @ModelAttribute("userRegisterBindingModel")
            UserRegisterBindingModel userRegisterBindingModel) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(
            @ModelAttribute("userRegisterBindingModel")
            @Valid UserRegisterBindingModel userRegisterBindingModel,
            BindingResult bindingResult) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }

        boolean successfulRegistration = userService.register(userRegisterBindingModel);

        if (!successfulRegistration) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("hasRegisterError", true);
            modelAndView.addObject("register");

            return modelAndView;
        }

        return new ModelAndView("redirect:/login");
    }



}
