package com.softuni.coffee_shop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column
    @Enumerated(EnumType.STRING)
    private CategoryName name;

    @Column
    @NotNull
    private int neededTime;

    public Category() {
    }

    public CategoryName getName() {
        return name;
    }

    public Category setName(CategoryName name) {
        this.name = name;
        return this;
    }

    public int getNeededTime() {
        return neededTime;
    }

    public Category setNeededTime(int neededTime) {
        this.neededTime = neededTime;
        return this;
    }

    private void setNeededTime(CategoryName name) {
        int neededTime = 0;

        switch (name) {
            case Coffee -> neededTime = 2;
            case Cake -> neededTime = 10;
            case Drink -> neededTime = 1;
            case Other -> neededTime = 5;
        }
        this.neededTime = neededTime;
    }
}
