package com.philately.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "stamps")
public class Stamp extends BaseEntity{

    @Column(nullable = false)
    @Length(min = 5, max = 20)
    private String name;

    @Column(nullable = false)
    @Length(min = 5, max = 25)
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    private Paper paper;

    @Column(nullable = false)
    @Positive
    private int price;

    @Column(nullable = false)
    @Length(max = 150)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    private User owner;

    public Stamp() {
    }

    public String getName() {
        return name;
    }

    public Stamp setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Stamp setDescription(String description) {
        this.description = description;
        return this;
    }

    public Paper getPaper() {
        return paper;
    }

    public Stamp setPaper(Paper paper) {
        this.paper = paper;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Stamp setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Stamp setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public Stamp setOwner(User owner) {
        this.owner = owner;
        return this;
    }
}
