package com.eshop.ordering.domain.events;

import com.eshop.ordering.domain.Order;

import lombok.Getter;

public class DraftOrderItemAdded extends OrderingEvent{

    @Getter
    private Order order;

    public DraftOrderItemAdded(Order order) {
        super(order.getId());

        this.order = order;
    }
    
}
