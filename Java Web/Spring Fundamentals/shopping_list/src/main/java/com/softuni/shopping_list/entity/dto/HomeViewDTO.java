package com.softuni.shopping_list.entity.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HomeViewDTO {

    private List<ProductDTO> foods;
    private List<ProductDTO> drinks;
    private List<ProductDTO> household;
    private List<ProductDTO> other;

    public HomeViewDTO() {
        this.foods = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.household = new ArrayList<>();
        this.other = new ArrayList<>();
    }

    public List<ProductDTO> getFoods() {
        return foods;
    }

    public HomeViewDTO setFoods(List<ProductDTO> foods) {
        this.foods = foods;
        return this;
    }

    public List<ProductDTO> getDrinks() {
        return drinks;
    }

    public HomeViewDTO setDrinks(List<ProductDTO> drinks) {
        this.drinks = drinks;
        return this;
    }

    public List<ProductDTO> getHousehold() {
        return household;
    }

    public HomeViewDTO setHousehold(List<ProductDTO> household) {
        this.household = household;
        return this;
    }

    public List<ProductDTO> getOther() {
        return other;
    }

    public HomeViewDTO setOther(List<ProductDTO> other) {
        this.other = other;
        return this;
    }


    public BigDecimal getTotalPrice() {

        BigDecimal totalPrice = null;

        totalPrice = getTotalPricePerCategory(foods, totalPrice);
        totalPrice = getTotalPricePerCategory(drinks, totalPrice);
        totalPrice = getTotalPricePerCategory(household, totalPrice);
        totalPrice = getTotalPricePerCategory(other, totalPrice);


        return totalPrice;
    }

    private static BigDecimal getTotalPricePerCategory(List<ProductDTO> list, BigDecimal priceAmounth) {
        for (ProductDTO p : list) {
            priceAmounth = BigDecimal.ZERO;
            priceAmounth = priceAmounth.add(new BigDecimal(String.valueOf(p.getPrice())));
        }
        return priceAmounth;
    }
}
