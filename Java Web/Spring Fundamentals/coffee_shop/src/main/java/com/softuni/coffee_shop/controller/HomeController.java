package com.softuni.coffee_shop.controller;

import com.softuni.coffee_shop.entity.dto.OrderViewModelDTO;
import com.softuni.coffee_shop.entity.dto.UserDTO;
import com.softuni.coffee_shop.service.LoggedUser;
import com.softuni.coffee_shop.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;

    private final OrderService orderService;

    public HomeController(LoggedUser loggedUser,
                          OrderService orderService) {
        this.loggedUser = loggedUser;
        this.orderService = orderService;
    }

    @GetMapping("/home")
    public ModelAndView home() {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        OrderViewModelDTO orders = this.orderService.getOrdersByPrice();
        List<UserDTO> usersByOrderCount = this.orderService.getAllByOrderCount();

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject(orders);
        modelAndView.addObject("usersByOrderCount", usersByOrderCount);

        return modelAndView;
    }

}
