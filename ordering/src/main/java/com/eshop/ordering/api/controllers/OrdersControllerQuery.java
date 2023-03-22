package com.eshop.ordering.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.ordering.domain.Order;
import com.eshop.ordering.domain.repositories.OrderRepository;

@RestController
@RequestMapping(path = "api/orders/qry")
public class OrdersControllerQuery {

    private OrderRepository repository;

    @Autowired
    public OrdersControllerQuery(OrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/draft")
    public ResponseEntity<List<Order>> GetAllOrders() {

        List<Order> orders = this.repository.getAll();

        return ResponseEntity.ok(orders);
    }
}
