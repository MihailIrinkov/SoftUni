package com.softuni.battleships.service;

import com.softuni.battleships.model.dto.ship.StartBattleDTO;

public interface BattleService {

    public void attack(StartBattleDTO startBattleDTO);
}
