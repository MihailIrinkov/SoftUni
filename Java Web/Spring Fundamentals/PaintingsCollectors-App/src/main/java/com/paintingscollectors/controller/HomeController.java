package com.paintingscollectors.controller;

import com.paintingscollectors.model.dto.HomeViewDTO;
import com.paintingscollectors.service.LoggedUser;
import com.paintingscollectors.service.PaintingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final PaintingService paintingService;

    public HomeController(LoggedUser loggedUser,
                          PaintingService paintingService) {
        this.loggedUser = loggedUser;
        this.paintingService = paintingService;
    }

    @GetMapping("/")
    public ModelAndView index() {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home(){

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        ModelAndView modelAndView = new ModelAndView("home");
        HomeViewDTO allMyPaintings = this.paintingService.getAll();
        modelAndView.addObject(allMyPaintings);

        return modelAndView;
    }

    @GetMapping("/add-to-favorites/{id}")
    public ModelAndView addToFavorites(
            @PathVariable("id") Long id
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        this.paintingService.addToFavorites(id);

        return new ModelAndView("redirect:/home");
    }


    @GetMapping("/paintings/remove-favorites/{id}")
    public ModelAndView removeFromFavorites(
            @PathVariable("id") Long id
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        this.paintingService.removeFromFavorites(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/painting-vote/{id}")
    public ModelAndView vote(
            @PathVariable("id") Long id
    ) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        this.paintingService.vote(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("delete-painting/{id}")
    public ModelAndView delete(
            @PathVariable("id") Long id
    ) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        this.paintingService.delete(id);

        return new ModelAndView("redirect:/home");
    }
}
