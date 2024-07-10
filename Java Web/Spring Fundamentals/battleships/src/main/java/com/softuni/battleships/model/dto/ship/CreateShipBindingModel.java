package com.softuni.battleships.model.dto.ship;

import com.softuni.battleships.model.entity.Category;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CreateShipBindingModel {

    @Column(nullable = false, unique = true)
    @Size(min = 2, max = 10)
    private String name;

    @Positive
    @Column(nullable = false)
    @NotNull
    private Long health;

    @Positive
    @Column(nullable = false)
    @NotNull
    private Long power;

    @Column(nullable = false)
    @PastOrPresent
    @NotNull
    private LocalDate created;

    @NotNull
    private Category category;

    public CreateShipBindingModel() {
    }

    public String getName() {
        return name;
    }

    public CreateShipBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public CreateShipBindingModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public CreateShipBindingModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public CreateShipBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public CreateShipBindingModel setCategory(Category category) {
        this.category = category;
        return this;
    }
}
