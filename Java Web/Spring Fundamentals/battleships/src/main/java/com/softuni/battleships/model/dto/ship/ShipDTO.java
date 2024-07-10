package com.softuni.battleships.model.dto.ship;

public class ShipDTO {

    private String name;

    private Long id;

    private Long health;
    private Long power;

    public ShipDTO() {
    }

    public String getName() {
        return name;
    }

    public ShipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ShipDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipDTO setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipDTO setPower(Long power) {
        this.power = power;
        return this;
    }
}
