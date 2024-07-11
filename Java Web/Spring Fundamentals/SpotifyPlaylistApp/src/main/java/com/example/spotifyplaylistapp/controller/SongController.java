package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.entity.dto.AddSongBindingModel;
import com.example.spotifyplaylistapp.service.LoggedUser;
import com.example.spotifyplaylistapp.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SongController {

    private final LoggedUser loggedUser;
    private final SongService songService;

    public SongController(LoggedUser loggedUser,
                          SongService songService) {
        this.loggedUser = loggedUser;
        this.songService = songService;
    }


    @GetMapping("/song-add")
    public ModelAndView addSong(
            @ModelAttribute("addSongBindingModel")
            AddSongBindingModel addSongBindingModel
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("song-add");
    }

    @PostMapping("/song-add")
    public ModelAndView addSong(
            @ModelAttribute("addSongBindingModel") @Valid
            AddSongBindingModel addSongBindingModel,
            BindingResult bindingResult
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("/song-add");
        }

        this.songService.addSong(addSongBindingModel);

        return new ModelAndView("redirect:/home");
    }
}
