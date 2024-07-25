package com.softuni.coffee_shop.entity.dto;

public class UserDTO {

    private String name;

    private Long id;

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public UserDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }
}
