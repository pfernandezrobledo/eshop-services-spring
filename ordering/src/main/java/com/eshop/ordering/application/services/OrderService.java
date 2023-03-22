package com.eshop.ordering.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eshop.ordering.application.commands.AddItemsToOrderCommand;
import com.eshop.ordering.application.commands.CreateOrderDraftCommand;

@Service
public class OrderService {

    private OrderAggregate aggregate;

    @Autowired
    public OrderService(OrderAggregate aggregate) {

        this.aggregate = aggregate;
    }

    public void handleCreateOrderDraftCommand(CreateOrderDraftCommand command) {

        this.aggregate.handleCreateOrderDraftCommand(command);

    }

    public void handleAddItemsToOrderCommand(AddItemsToOrderCommand command) throws Exception {

        this.aggregate.handleAddItemsToOrderCommand(command);

    }

}
