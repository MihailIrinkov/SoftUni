package com.softuni.coffee_shop.controller;

import com.softuni.coffee_shop.entity.dto.AddOrderBindingModel;
import com.softuni.coffee_shop.service.LoggedUser;
import com.softuni.coffee_shop.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    private final LoggedUser loggedUser;

    private final OrderService orderService;

    public OrderController(LoggedUser loggedUser,
                           OrderService orderService) {
        this.loggedUser = loggedUser;
        this.orderService = orderService;
    }

    @GetMapping("/order-ready/{id}")
    public ModelAndView ready(
            @PathVariable("id")
            Long id
    ) {
        this.orderService.ready(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/order-add")
    public ModelAndView addOrder(
            @ModelAttribute("addOrderBindingModel")
            AddOrderBindingModel addOrderBindingModel
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("order-add");
    }

    @PostMapping("/order-add")
    public ModelAndView addOrder(
            @ModelAttribute("addOrderBindingModel") @Valid
            AddOrderBindingModel addOrderBindingModel,
            BindingResult bindingResult
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("order-add");
        }

        this.orderService.addOrder(addOrderBindingModel);

        return new ModelAndView("redirect:/home");
    }

}
