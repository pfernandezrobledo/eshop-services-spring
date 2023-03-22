package com.eshop.ordering.application.services;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eshop.ordering.application.commands.AddItemsToOrderCommand;
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

        

        // I was getting an error about 'persisting detached item', tuyrns out i was
        // setting the OrderItem ID
        // when i was supposed to leave it blank
        List<OrderItems> listOfItems = command
                .getItems()
                .stream()
                .map(
                        item -> new OrderItems(
                                item.getProductName(),
                                item.getUnitPrice(),
                                item.getUnits(),
                                null))
                .toList();

        Order order = new Order(command.getBuyerId(),listOfItems);

        this.repository.save(order);

        // List<Order> results = this.repository.findAll();
    }

    public void handleAddItemsToOrderCommand(AddItemsToOrderCommand command) throws Exception {

        Optional<Order> orderOptional = this.repository.findById(command.getOrderId());

        if (orderOptional.isPresent()) {

            Order order = orderOptional.get();


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



            order.AddOrderItems(listOfItems);

            this.repository.save(order);

        } else {
            throw new Exception("There was no order found for the given ID");
        }
    }


}
