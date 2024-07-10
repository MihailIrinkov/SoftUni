package com.softuni.battleships.model.dto.ship;

import java.util.ArrayList;
import java.util.List;

public class ShipViewDTO {

    private List<ShipDTO> ownShips;
    private List<ShipDTO> notOwnShips;
    private List<ShipDTO> allShips;

    public ShipViewDTO() {
        ownShips =new ArrayList<>();
        notOwnShips = new ArrayList<>();
        allShips = new ArrayList<>();
    }

    public List<ShipDTO> getOwnShips() {
        return ownShips;
    }

    public ShipViewDTO setOwnShips(List<ShipDTO> ownShips) {
        this.ownShips = ownShips;
        return this;
    }

    public List<ShipDTO> getNotOwnShips() {
        return notOwnShips;
    }

    public ShipViewDTO setNotOwnShips(List<ShipDTO> notOwnShips) {
        this.notOwnShips = notOwnShips;
        return this;
    }

    public List<ShipDTO> getAllShips() {
        return allShips;
    }

    public ShipViewDTO setAllShips(List<ShipDTO> allShips) {
        this.allShips = allShips;
        return this;
    }
}
