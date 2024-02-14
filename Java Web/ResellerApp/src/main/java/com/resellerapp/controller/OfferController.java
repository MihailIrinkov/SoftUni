package com.resellerapp.controller;

import com.resellerapp.model.OfferCreateBindingModel;
import com.resellerapp.service.LoggedUser;
import com.resellerapp.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/offers")
public class OfferController {

    private final OfferService offerService;
    private final LoggedUser loggedUser;

    public OfferController(OfferService offerService, LoggedUser loggedUser) {
        this.offerService = offerService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/create")
    public ModelAndView create() {

        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("offer-add");
    }

    @PostMapping("/create")
    public ModelAndView create(OfferCreateBindingModel offerCreateBindingModel) {

        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        boolean isCreated = this.offerService.create(offerCreateBindingModel);

        String view = isCreated ? "redirect:/home" : "/create";
        return new ModelAndView(view);
    }

    @PostMapping("/buy/{id}")
    public ModelAndView buyOffer(@PathVariable("id") UUID id) {

        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        offerService.buy(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/remove/{id}")
    public ModelAndView removeOffer(@PathVariable("id") UUID id) {

        if(!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        offerService.remove(id);

        return new ModelAndView("redirect:/home");
    }

}
