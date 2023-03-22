package com.eshop.ordering.domain.events;

import java.time.LocalDate;
import java.util.UUID;

import lombok.Getter;


public class OrderingEvent {
    
    @Getter
    private UUID eventId;
    @Getter
    private LocalDate eventDate;

    @Getter
    private Long orderId;

    public OrderingEvent(Long orderId) {
        this.orderId = orderId;
    }   

}
