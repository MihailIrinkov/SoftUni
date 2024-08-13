package com.paintingscollectors.model.entity;

import javax.persistence.*;

@Entity
@Table
public class Style extends BaseEntity{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StyleName name;

    @Column(nullable = false)
    private String description;

    public Style() {
    }

    public StyleName getName() {
        return name;
    }

    public Style setName(StyleName name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Style setDescription(String description) {
        this.description = description;
        return this;
    }
}
