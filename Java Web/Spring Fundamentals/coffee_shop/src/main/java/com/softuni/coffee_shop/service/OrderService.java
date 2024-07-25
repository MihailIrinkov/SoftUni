package com.softuni.coffee_shop.service;

import com.softuni.coffee_shop.entity.dto.AddOrderBindingModel;
import com.softuni.coffee_shop.entity.dto.OrderViewModelDTO;
import com.softuni.coffee_shop.entity.dto.UserDTO;

import java.util.List;

public interface OrderService {

    void addOrder(AddOrderBindingModel addOrderBindingModel);

    OrderViewModelDTO getOrdersByPrice();

    void ready(Long id);

    List<UserDTO> getAllByOrderCount();
}
