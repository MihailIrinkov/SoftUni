package com.softuni.shopping_list.service;

import com.softuni.shopping_list.entity.dto.HomeViewDTO;

public interface HomeService {

    HomeViewDTO getProducts();

    void buySingleProduct(Long id);

    void buyAllProducts();
}
