package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.entity.dto.HomeViewDTO;
import com.example.spotifyplaylistapp.service.HomeService;
import com.example.spotifyplaylistapp.service.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final HomeService homeService;

    public HomeController(LoggedUser loggedUser,
                          HomeService homeService) {
        this.loggedUser = loggedUser;
        this.homeService = homeService;
    }

    @GetMapping("/home")
    public ModelAndView home(

    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        HomeViewDTO homeViewDTO = this.homeService.homeView();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject(homeViewDTO);

        return modelAndView;
    }

    @GetMapping("/home/add-song-to-playlist/{id}")
    public ModelAndView addSongToPlaylist(@PathVariable("id") Long id) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        this.homeService.addSongToPlayList(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/home/{username}")
    public ModelAndView deletePlayList(@PathVariable("username") String username) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        this.homeService.deletePlayList(username);

        return new ModelAndView("redirect:/home");
    }
}
