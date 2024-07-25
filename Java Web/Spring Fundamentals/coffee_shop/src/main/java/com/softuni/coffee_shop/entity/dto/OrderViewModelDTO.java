package com.softuni.coffee_shop.entity.dto;

import com.softuni.coffee_shop.entity.CategoryName;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderViewModelDTO {

    private List<OrderDTO> orders;

    public OrderViewModelDTO() {
        this.orders = new ArrayList<>();
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public OrderViewModelDTO setOrders(List<OrderDTO> orders) {
        this.orders = orders;
        return this;
    }

    public BigDecimal getTotalOrderPrice(List<OrderDTO> orders) {

        BigDecimal price = BigDecimal.ZERO;

        for (OrderDTO order : orders) {
            price = price.add(order.getPrice());
        }

        return price;
    }

    public int getTotalOrderTime() {

        int totalTime = 0;

        for (OrderDTO order : this.orders) {
                    if (order.getCategoryName().equals(CategoryName.Cake)) {
                        totalTime = totalTime + 10;
                    } else if (order.getCategoryName().equals(CategoryName.Coffee)) {
                        totalTime = totalTime + 2;
                    } else if (order.getCategoryName().equals(CategoryName.Drink)) {
                        totalTime = totalTime + 1;
                    } else if (order.getCategoryName().equals(CategoryName.Other)) {
                        totalTime = totalTime + 5;
                    }
                }

        return totalTime;
    }

    public int getOrderCount(Long id) {

        int orderCount = 0;

        for (OrderDTO order : this.orders) {
            if (order.getEmployee_id() == id) {
                orderCount++;
            }
        }

        return orderCount;
    }
}
