package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.WordDTO;
import com.dictionaryapp.model.dto.word.WordHomeViewModel;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final WordService wordService;
    private final UserService userService;

    public HomeController(LoggedUser loggedUser, WordService wordService, UserService userService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView index() {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("/index");
    }

    @GetMapping("/home")
    public ModelAndView home() {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        WordHomeViewModel homeViewModel = wordService.getWords();

//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("allWords", homeViewModel);

//        List<WordDTO> allGermanWords = homeViewModel.getGermanWords();
//
//        modelAndView.addObject("allGermanWords", allGermanWords);
//        modelAndView.addObject("allFrenchWords", homeViewModel.getFrenchWords());
//        modelAndView.addObject("allSpanishWords", homeViewModel.getSpanishWords());
//        modelAndView.addObject("allItalianWords", homeViewModel.getItalianWords());

//        return modelAndView;

        Long count = this.wordService.getWordsCount();

        return new ModelAndView("home", "allWords", homeViewModel);
    }

    @GetMapping("/home/remove-word-by-id/{id}")
    public ModelAndView remove(@PathVariable("id") Long id) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        wordService.removeById(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/home/remove-all-words")
    public ModelAndView removeAll() {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        wordService.removeAll();

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/home/logout")
    public ModelAndView logout() {
        userService.logout();
        return new ModelAndView("redirect:/");
    }

}
