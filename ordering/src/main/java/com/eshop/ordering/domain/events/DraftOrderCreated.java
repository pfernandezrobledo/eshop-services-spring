package com.eshop.ordering.domain.events;

import com.eshop.ordering.domain.Order;

import lombok.Getter;

public class DraftOrderCreated extends OrderingEvent{

    @Getter
    private Order order;

    public DraftOrderCreated(Order order) {
        super(order.getId());

        this.order = order;
    }
    
}
