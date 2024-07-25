package com.softuni.coffee_shop.service.impl;

import com.softuni.coffee_shop.entity.Category;
import com.softuni.coffee_shop.entity.CategoryName;
import com.softuni.coffee_shop.entity.Order;
import com.softuni.coffee_shop.entity.User;
import com.softuni.coffee_shop.entity.dto.AddOrderBindingModel;
import com.softuni.coffee_shop.entity.dto.OrderDTO;
import com.softuni.coffee_shop.entity.dto.OrderViewModelDTO;
import com.softuni.coffee_shop.entity.dto.UserDTO;
import com.softuni.coffee_shop.repository.CategoryRepository;
import com.softuni.coffee_shop.repository.OrderRepository;
import com.softuni.coffee_shop.repository.UserRepository;
import com.softuni.coffee_shop.service.LoggedUser;
import com.softuni.coffee_shop.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final LoggedUser loggedUser;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository,
                            LoggedUser loggedUser,
                            CategoryRepository categoryRepository,
                            UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.loggedUser = loggedUser;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addOrder(AddOrderBindingModel addOrderBindingModel) {

        Category category =
                this.categoryRepository.findByName(addOrderBindingModel.getCategory()).get();
        User user = this.userRepository.findByUsername(loggedUser.getUsername()).get();

        Order order = new Order()
                .setName(addOrderBindingModel.getName())
                .setPrice(addOrderBindingModel.getPrice())
                .setTime(addOrderBindingModel.getTime())
                .setCategory(category)
                .setDescription(addOrderBindingModel.getDescription())
                .setEmployee(user);

        this.orderRepository.save(order);
    }

    @Override
    public OrderViewModelDTO getOrdersByPrice() {

        List<OrderDTO> orders = this.orderRepository.findAllByOrderByPriceDesc()
                .stream().map(order -> new OrderDTO()
                        .setDescription(order.getDescription())
                        .setPrice(order.getPrice())
                        .setCategoryName(order.getCategory().getName())
                        .setName(order.getName())
                        .setId(order.getId())
                        .setEmployee_id(order.getEmployee().getId()))
                .collect(Collectors.toList());

        OrderViewModelDTO orderViewModelDTO = new OrderViewModelDTO().setOrders(orders);

        return orderViewModelDTO;
    }

    @Override
    public void ready(Long id) {
        Order orderToDelete = this.orderRepository.findById(id).get();

        this.orderRepository.delete(orderToDelete);
    }

    @Override
    public List<UserDTO> getAllByOrderCount() {

        List<UserDTO> sortedByOrder = new ArrayList<>();

        List<Long> allByOrderCount = this.orderRepository.findAllByOrderCount();

        for (Long id : allByOrderCount) {

            User userById = this.userRepository.findById(id).get();

            UserDTO user = new UserDTO()
                    .setId(userById.getId())
                    .setName(userById.getLastName());
            sortedByOrder.add(user);
        }

        return sortedByOrder;
    }

}
