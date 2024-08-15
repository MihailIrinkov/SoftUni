package com.philately.controller;

import com.philately.model.dto.AddStampBindingModel;
import com.philately.service.LoggedUser;
import com.philately.service.StampService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StampController {

    private final StampService stampService;
    private final LoggedUser loggedUser;

    public StampController(StampService stampService,
                           LoggedUser loggedUser) {
        this.stampService = stampService;

        this.loggedUser = loggedUser;
    }

    @GetMapping("/add-stamp")
    public ModelAndView addStamp(
            @ModelAttribute("addStampBindingModel")
            AddStampBindingModel addStampBindingModel
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        return new ModelAndView("add-stamp");
    }

    @PostMapping("/add-stamp")
    public ModelAndView addStamp(
            @ModelAttribute("addStampBindingModel") @Valid
            AddStampBindingModel addStampBindingModel,
            BindingResult bindingResult
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/login");
        }

        if (bindingResult.hasErrors()) {
            return new ModelAndView("add-stamp");
        }

        this.stampService.addStamp(addStampBindingModel);

        return new ModelAndView("redirect:/home");
    }

}
