package com.eshop.ordering.application.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eshop.ordering.application.commands.CreateOrderDraftCommand;
import com.eshop.ordering.domain.Order;
import com.eshop.ordering.domain.OrderItems;
import com.eshop.ordering.domain.repositories.OrderRepository;

@Component
public class OrderAggregate {

    private OrderRepository repository;

    @Autowired
    public OrderAggregate(OrderRepository repository) {
        this.repository = repository;
    }

    public void handleCreateOrderDraftCommand(CreateOrderDraftCommand command) {

        Order order = new Order();

        // I was getting an error about 'persisting detached item', tuyrns out i was setting the OrderItem ID
        // when i was supposed to leave it blank
        List<OrderItems> listOfItems = command
                .getItems()
                .stream()
                .map(
                        item -> new OrderItems(
                                item.getProductName(),
                                item.getUnitPrice(),
                                item.getUnits(),
                                order))
                .toList();

        order.setBuyerId(command.getBuyerId());
        order.setItems(listOfItems);

        this.repository.save(order);

        // List<Order> results = this.repository.findAll();
    }

}
