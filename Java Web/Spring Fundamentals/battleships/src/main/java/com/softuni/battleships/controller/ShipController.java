package com.softuni.battleships.controller;

import com.softuni.battleships.model.dto.ship.CreateShipBindingModel;
import com.softuni.battleships.service.LoggedUser;
import com.softuni.battleships.service.ShipService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShipController {

    private final LoggedUser loggedUser;
    private final ShipService shipService;

    public ShipController(LoggedUser loggedUser,
                          ShipService shipService) {
        this.loggedUser = loggedUser;
        this.shipService = shipService;
    }


    @GetMapping("/ship-add")
    public ModelAndView addShip(
            @ModelAttribute("createShipBindingModel")
            CreateShipBindingModel createShipBindingModel
    ) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("ship-add");
    }

    @PostMapping("/ship-add")
    public ModelAndView addShip(
            @ModelAttribute("createShipBindingModel") @Valid
            CreateShipBindingModel createShipBindingModel,
            BindingResult bindingResult
    ) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("ship-add");
        }

        boolean hasSuccessfulCreateShip = this.shipService.createShip(createShipBindingModel);

        if (!hasSuccessfulCreateShip) {
            ModelAndView modelAndView = new ModelAndView("ship-add");
            modelAndView.addObject("hasCreateError", true);
        }

        return new ModelAndView("redirect:home");
    }

}
