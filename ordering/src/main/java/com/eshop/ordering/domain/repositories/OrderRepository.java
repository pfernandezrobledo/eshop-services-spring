package com.eshop.ordering.domain.repositories;

import java.util.List;
import java.util.Optional;

import com.eshop.ordering.domain.Order;


public interface OrderRepository {

    void save(Order order);

    Optional<Order> findById(Long id);

    List<Order> getAll();
}
