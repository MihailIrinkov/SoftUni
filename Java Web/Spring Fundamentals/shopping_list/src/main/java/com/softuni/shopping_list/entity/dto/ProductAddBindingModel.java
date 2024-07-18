package com.softuni.shopping_list.entity.dto;

import com.softuni.shopping_list.entity.Category;
import com.softuni.shopping_list.entity.CategoryName;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ProductAddBindingModel {


    @Size(min = 3, max = 20)
    @NotBlank(message = "Name lenght musst be between 3 and 20 characters")
    private String name;

    @Size(min = 5)
    @NotBlank(message = "Description lenght musst be more than 5 characters")
    private String description;

    @Positive(message = "Price musst be positive number")
    private BigDecimal price;

    @FutureOrPresent(message = "The date cannot be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime neededBefore;

    @NotNull
    private CategoryName category;

    public ProductAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public CategoryName getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoryName category) {
        this.category = category;
        return this;
    }
}
