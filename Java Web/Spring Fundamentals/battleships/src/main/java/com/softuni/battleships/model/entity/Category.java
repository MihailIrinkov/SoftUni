package com.softuni.battleships.model.entity;

import com.softuni.battleships.model.entity.enums.CategoryType;
import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private CategoryType name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public Category() {
    }

    public CategoryType getName() {
        return name;
    }

    public Category setName(CategoryType name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Category setDescription(String description) {
        this.description = description;
        return this;
    }
}
