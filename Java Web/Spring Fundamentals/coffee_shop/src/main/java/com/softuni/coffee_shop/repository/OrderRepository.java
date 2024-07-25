package com.softuni.coffee_shop.repository;

import com.softuni.coffee_shop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.expression.spel.ast.OpOr;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findAllByOrderByPriceDesc();

    Optional<Order> findById(Long id);

    @Query(nativeQuery = true, value = "SELECT employee_id\n" +
            "FROM\n" +
            "    orders\n" +
            "GROUP BY employee_id\n" +
            "ORDER BY COUNT(employee_id) DESC;")
    List<Long> findAllByOrderCount();
}
