package com.softuni.shopping_list.controller;

import com.softuni.shopping_list.entity.dto.HomeViewDTO;
import com.softuni.shopping_list.service.HomeService;
import com.softuni.shopping_list.service.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final HomeService homeService;

    public HomeController(LoggedUser loggedUser, HomeService
            homeService) {
        this.loggedUser = loggedUser;
        this.homeService = homeService;
    }

    @GetMapping("/")
    public ModelAndView index() {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(
            @ModelAttribute("homeViewDTO")
            HomeViewDTO homeViewDTO
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        HomeViewDTO products = this.homeService.getProducts();

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject(products);

        return modelAndView;
    }

    @GetMapping("/home/by-single-product/{id}")
    public ModelAndView buySingleProduct(
            @PathVariable("id") Long id
    )
    {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        this.homeService.buySingleProduct(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/home/buy-all-products")
    public ModelAndView buyAllProducts() {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        this.homeService.buyAllProducts();

        return new ModelAndView("redirect:/home");
    }
}
