package com.softuni.coffee_shop.entity.dto;

import com.softuni.coffee_shop.entity.CategoryName;

import java.math.BigDecimal;

public class OrderDTO {

    private Long id;

    private BigDecimal price;

    private String description;

    private CategoryName categoryName;

    private String name;

    private Long employee_id;

    public OrderDTO() {
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public OrderDTO setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
        return this;
    }

    public Long getId() {
        return id;
    }

    public OrderDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrderDTO setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryName getCategoryName() {
        return categoryName;
    }

    public OrderDTO setCategoryName(CategoryName categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public OrderDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public OrderDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
