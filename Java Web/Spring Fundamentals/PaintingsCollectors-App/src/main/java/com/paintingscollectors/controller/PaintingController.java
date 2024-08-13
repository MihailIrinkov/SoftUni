package com.paintingscollectors.controller;

import com.paintingscollectors.model.dto.AddPaintingBindingModel;
import com.paintingscollectors.service.LoggedUser;
import com.paintingscollectors.service.PaintingService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PaintingController {

    private final LoggedUser loggedUser;
    private final PaintingService paintingService;

    public PaintingController(LoggedUser loggedUser,
                              PaintingService paintingService) {
        this.loggedUser = loggedUser;
        this.paintingService = paintingService;
    }

    @GetMapping("/add-painting")
    public ModelAndView addPainting(
            @ModelAttribute("addPaintingBindingModel")
            AddPaintingBindingModel addPaintingBindingModel
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("add-painting");
    }

    @PostMapping("/add-painting")
    public ModelAndView addPainting(
            @ModelAttribute("addPaintingBindingModel") @Valid
            AddPaintingBindingModel addPaintingBindingModel,
            BindingResult bindingResult
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("add-painting");
        }

        this.paintingService.addPainting(addPaintingBindingModel);

        return new ModelAndView("redirect:/home");
    }

}
