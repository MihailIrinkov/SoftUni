package com.softuni.shopping_list.entity.dto;

import java.math.BigDecimal;

public class ProductDTO {

    private Long id;
    private String name;

    private BigDecimal price;

    public ProductDTO() {
    }

    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ProductDTO setId(Long id) {
        this.id = id;
        return this;
    }
}
