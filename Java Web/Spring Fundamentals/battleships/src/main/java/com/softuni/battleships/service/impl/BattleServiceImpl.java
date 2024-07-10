package com.softuni.battleships.service.impl;

import com.softuni.battleships.model.dto.ship.StartBattleDTO;
import com.softuni.battleships.model.entity.Ship;
import com.softuni.battleships.repository.ShipRepository;
import com.softuni.battleships.service.BattleService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BattleServiceImpl implements BattleService {

    private final ShipRepository shipRepository;

    public BattleServiceImpl(ShipRepository shipRepository) {
        this.shipRepository = shipRepository;
    }

    @Override
    public void attack(StartBattleDTO startBattleDTO) {
        Optional<Ship> attackerOpt = this.shipRepository.findById(startBattleDTO.getAttackerId());
        Optional<Ship> defenderOpt = this.shipRepository.findById(startBattleDTO.getDefenderId());

        if (attackerOpt.isEmpty() || defenderOpt.isEmpty()) {
            throw new NoSuchElementException();
        }

        Ship attacker = attackerOpt.get();
        Ship defender = defenderOpt.get();

        Long power = attacker.getPower();
        Long health = defender.getHealth();

        Long result = health - power;

        if (result <= 0) {
            this.shipRepository.delete(defender);
        } else {
            defender.setHealth(result);
            this.shipRepository.save(defender);
        }

    }
}
