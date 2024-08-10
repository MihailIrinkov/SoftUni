package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.HomeViewDTO;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final WordService wordService;

    public HomeController(LoggedUser loggedUser,
                          WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
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

        HomeViewDTO allWords = this.wordService.getAll();

        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject(allWords);

        return modelAndView;
    }
}
