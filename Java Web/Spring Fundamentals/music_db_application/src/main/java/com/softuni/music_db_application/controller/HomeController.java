package com.softuni.music_db_application.controller;

import com.softuni.music_db_application.model.dto.AlbumDTO;
import com.softuni.music_db_application.model.dto.HomeViewDTO;
import com.softuni.music_db_application.model.entity.Album;
import com.softuni.music_db_application.service.AlbumService;
import com.softuni.music_db_application.service.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final AlbumService albumService;

    public HomeController(LoggedUser loggedUser,
                          AlbumService albumService) {
        this.loggedUser = loggedUser;
        this.albumService = albumService;
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

        ModelAndView modelAndView = new ModelAndView("/home");
        List<AlbumDTO> allAlbums = this.albumService.getAllAlbums();

        HomeViewDTO homeViewDTO = new HomeViewDTO();
        homeViewDTO.setAlbums(allAlbums);

        modelAndView.addObject("allAlbums", homeViewDTO);

        return modelAndView;
    }
}
