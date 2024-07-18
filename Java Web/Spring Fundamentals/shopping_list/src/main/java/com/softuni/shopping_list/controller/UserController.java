package com.softuni.shopping_list.controller;

import com.softuni.shopping_list.entity.dto.UserLoginBindingModel;
import com.softuni.shopping_list.entity.dto.UserRegistrationBindingModel;
import com.softuni.shopping_list.service.LoggedUser;
import com.softuni.shopping_list.service.UserService;
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
    @GetMapping("/register")
    public ModelAndView register(
            @ModelAttribute("userRegistrationBindingModel")
            UserRegistrationBindingModel userRegistrationBindingModel
    ) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView register(
            @ModelAttribute("userRegistrationBindingModel") @Valid
            UserRegistrationBindingModel userRegistrationBindingModel,
            BindingResult bindingResult
    ) {
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("register");
        }


        boolean hasSuccessfulRegister = this.userService.register(userRegistrationBindingModel);

        if (!hasSuccessfulRegister) {
            return new ModelAndView("register");
        }

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/login")
    public ModelAndView login(
            @ModelAttribute("userLoginBindingModel")
            UserLoginBindingModel userLoginBindingModel
    ) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(
            @ModelAttribute("userLoginBindingModel") @Valid
            UserLoginBindingModel userLoginBindingModel,
            BindingResult bindingResult
    ) {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
//            modelAndView.addObject("hasError", true);
            return modelAndView;
        }

        boolean hasSuccessfulLogin = this.userService.login(userLoginBindingModel);

        if (!hasSuccessfulLogin) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("hasError", true);
            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }
    @GetMapping("/logout")
    public ModelAndView logout(){

        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        this.userService.logout();

        return new ModelAndView("redirect:/");
    }
}
