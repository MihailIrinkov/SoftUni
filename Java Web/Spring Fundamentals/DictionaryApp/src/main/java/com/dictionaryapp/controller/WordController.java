package com.dictionaryapp.controller;

import com.dictionaryapp.model.dto.AddWordBindingModel;
import com.dictionaryapp.service.LoggedUser;
import com.dictionaryapp.service.WordService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    public WordController(LoggedUser loggedUser,
                          WordService wordService) {
        this.loggedUser = loggedUser;
        this.wordService = wordService;
    }

    @GetMapping("/word-add")
    public ModelAndView addWord(
            @ModelAttribute("addWordBindingModel")
            AddWordBindingModel addWordBindingModel
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("word-add");
    }

    @PostMapping("/word-add")
    public ModelAndView addWord(
            @ModelAttribute("addWordBindingModel") @Valid
            AddWordBindingModel addWordBindingModel,
            BindingResult bindingResult
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("word-add");
            modelAndView.addObject("hasAddError", true);

            return modelAndView;
        }

        this.wordService.addWord(addWordBindingModel);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/word/delete/{id}")
    public ModelAndView modelAndView(
            @PathVariable("id")
            Long id
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        this.wordService.delete(id);

        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/word/delete/all")
    public ModelAndView deleteAll() {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        this.wordService.deleteAll();

        return new ModelAndView("redirect:/home");
    }
}
