package com.softuni.battleships.model.dto.ship;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class StartBattleDTO {

    @Positive
    @NotNull
    private Long attackerId;

    @Positive
    @NotNull
    private Long defenderId;

    public StartBattleDTO() {
    }

    public Long getAttackerId() {
        return attackerId;
    }

    public StartBattleDTO setAttackerId(Long attackerId) {
        this.attackerId = attackerId;
        return this;
    }

    public Long getDefenderId() {
        return defenderId;
    }

    public StartBattleDTO setDefenderId(Long defenderId) {
        this.defenderId = defenderId;
        return this;
    }
}
