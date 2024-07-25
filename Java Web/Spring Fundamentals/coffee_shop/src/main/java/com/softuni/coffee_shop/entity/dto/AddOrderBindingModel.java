package com.softuni.coffee_shop.entity.dto;

import com.softuni.coffee_shop.entity.Category;
import com.softuni.coffee_shop.entity.CategoryName;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AddOrderBindingModel {

    @Size(min = 3, max = 20)
    private String name;

    @Positive
    @NotNull
    private BigDecimal price;

    @PastOrPresent
    @NotNull
    private LocalDateTime time;

    @NotNull
    private CategoryName category;

    @NotBlank
    @Size(min = 5)
    private String description;

    public AddOrderBindingModel() {
    }

    public String getName() {
        return name;
    }

    public AddOrderBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public AddOrderBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public AddOrderBindingModel setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public AddOrderBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddOrderBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }
}
