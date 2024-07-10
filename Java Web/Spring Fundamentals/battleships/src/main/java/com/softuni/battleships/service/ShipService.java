package com.softuni.battleships.service;

import com.softuni.battleships.model.dto.ship.CreateShipBindingModel;
import com.softuni.battleships.model.dto.ship.ShipDTO;

import java.util.List;

public interface ShipService {

    boolean createShip(CreateShipBindingModel createShipBindingModel);

//    boolean attack(ShipViewDTO shipViewDTO);

     List<ShipDTO> getOwnShips(Long id);
     List<ShipDTO> getNotOwnShips(Long id);
     List<ShipDTO> getSortedAllShips();
}
