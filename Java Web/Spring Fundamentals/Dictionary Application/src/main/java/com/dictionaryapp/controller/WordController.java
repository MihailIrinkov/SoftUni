package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.word.WordBindingModel;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WordController {

    private final LoggedUser loggedUser;

    private final WordService wordService;

    public WordController(LoggedUser loggedUser, WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
    }

    @GetMapping("/word-add")
    public ModelAndView add(
            @ModelAttribute("wordBindingModel")
            WordBindingModel wordBindingModel
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        return new ModelAndView("word-add");
    }

    @PostMapping("/word-add")
    public ModelAndView add(
            @ModelAttribute("wordBindingModel")
            @Valid WordBindingModel wordBindingModel,
            BindingResult bindingResult
    ) {
        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("word-add");
        }

        boolean successfulAddWord = this.wordService.addWord(wordBindingModel);

        if (!successfulAddWord) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("hasAddError", true);
            modelAndView.addObject("word-add");

            return modelAndView;
        }

        return new ModelAndView("redirect:/home");
    }

}
