package com.softuni.battleships.controller;

import com.softuni.battleships.model.dto.ship.StartBattleDTO;
import com.softuni.battleships.service.BattleService;
import com.softuni.battleships.service.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BattleController {

    private final BattleService battleService;
    private final LoggedUser loggedUser;

    public BattleController(BattleService battleService,
                            LoggedUser loggedUser) {
        this.battleService = battleService;
        this.loggedUser = loggedUser;
    }

    @PostMapping("/battle")
    public ModelAndView battle(
            @ModelAttribute("startBattleDTO") @Valid
            StartBattleDTO startBattleDTO,
            BindingResult bindingResult
    ) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        if (bindingResult.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("home");
            modelAndView.addObject("hasBattleError", true);
        }

        this.battleService.attack(startBattleDTO);

        return new ModelAndView("home");
    }

}
