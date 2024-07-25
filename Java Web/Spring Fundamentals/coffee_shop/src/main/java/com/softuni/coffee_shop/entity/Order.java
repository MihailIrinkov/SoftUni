package com.softuni.coffee_shop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity{

    @Column(nullable = false)
    @Length(min = 3, max = 20)
    private String name;


    @Column
    @Positive
    @NotNull
    private BigDecimal price;

    @Column(name = "order_time")
    @PastOrPresent
    @NotNull
    private LocalDateTime time;

    @ManyToOne
    private Category category;

    @Column(columnDefinition = "TEXT", nullable = false)
    @Length(min = 5)
    private String description;

    @ManyToOne
    private User employee;

    public Order() {
    }

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Order setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public Order setTime(LocalDateTime time) {
        this.time = time;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public Order setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Order setDescription(String description) {
        this.description = description;
        return this;
    }

    public User getEmployee() {
        return employee;
    }

    public Order setEmployee(User employee) {
        this.employee = employee;
        return this;
    }
}
