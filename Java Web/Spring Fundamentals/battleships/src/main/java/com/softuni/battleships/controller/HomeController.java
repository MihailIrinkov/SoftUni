package com.softuni.battleships.controller;

import com.softuni.battleships.model.dto.ship.ShipDTO;
import com.softuni.battleships.model.dto.ship.StartBattleDTO;
import com.softuni.battleships.service.LoggedUser;
import com.softuni.battleships.service.ShipService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final LoggedUser loggedUser;
    private final ShipService shipService;

    public HomeController(LoggedUser loggedUser,
                          ShipService shipService) {
        this.loggedUser = loggedUser;
        this.shipService = shipService;
    }

    @GetMapping("/")
    public ModelAndView loggedOutUser() {

        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView loggedInUser(@ModelAttribute("startBattleDTO")
                                     StartBattleDTO startBattleDTO) {

        if (!loggedUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        List<ShipDTO> ownShips = this.shipService.getOwnShips(loggedUser.getId());
        List<ShipDTO> notOwnShips = this.shipService.getNotOwnShips(loggedUser.getId());
        List<ShipDTO> allShips = this.shipService.getSortedAllShips();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("ownShips", ownShips);
        modelAndView.addObject("notOwnShips", notOwnShips);
        modelAndView.addObject("allShips", allShips);

        return modelAndView;
    }
}
