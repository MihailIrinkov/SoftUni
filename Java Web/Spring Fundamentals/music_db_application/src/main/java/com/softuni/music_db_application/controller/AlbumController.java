package com.softuni.music_db_application.controller;

import com.softuni.music_db_application.model.dto.AddAlbumBindingModel;
import com.softuni.music_db_application.service.AlbumService;
import com.softuni.music_db_application.service.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlbumController {

    private final LoggedUser loggedUser;
    private final AlbumService albumService;

    public AlbumController(LoggedUser loggedUser,
                           AlbumService albumService) {
        this.loggedUser = loggedUser;
        this.albumService = albumService;
    }

    @GetMapping("/add-album")
    public ModelAndView addAlbum(
            @ModelAttribute("addAlbumBindingModel")
    AddAlbumBindingModel addAlbumBindingModel
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("add-album");
    }

    @PostMapping("/add-album")
    public ModelAndView addAlbum(
            @ModelAttribute("addAlbumBindingModel") @Valid
    AddAlbumBindingModel addAlbumBindingModel,
            BindingResult bindingResult
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/add-album");
        }

        this.albumService.addAlbum(addAlbumBindingModel);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/delete-album/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        this.albumService.delete(id);

        return new ModelAndView("redirect:/home");
    }
}
