package com.philately.controller;

import com.philately.model.dto.HomeViewDTO;
import com.philately.model.dto.StampDTO;
import com.philately.service.LoggedUser;
import com.philately.service.StampService;
import com.philately.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Set;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final StampService stampService;
    private final UserService userService;

    public HomeController(LoggedUser loggedUser,
                          StampService stampService,
                          UserService userService) {
        this.loggedUser = loggedUser;
        this.stampService = stampService;
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView index() {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home() {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("home");
        HomeViewDTO homeView = this.stampService.getHomeView();
        modelAndView.addObject(homeView);

        return modelAndView;
    }

    @GetMapping("/add-to-wish-list/{id}")
    public ModelAndView addToWishList(
            @PathVariable("id") Long id
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        this.stampService.addToWishList(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/remove-from-wishlist/{id}")
    public ModelAndView removeFromWishList(
            @PathVariable("id") Long id
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        this.userService.removeFromWishList(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/buy-stamps/{username}")
    public ModelAndView buyStamp(
            @PathVariable("username")
            String username
    ) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        this.userService.buyStamp(username);

        return new ModelAndView("redirect:/home");
    }
}
