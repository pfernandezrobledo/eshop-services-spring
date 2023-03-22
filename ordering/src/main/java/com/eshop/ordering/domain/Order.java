package com.eshop.ordering.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.AbstractAggregateRoot;

import com.eshop.ordering.domain.events.DraftOrderCreated;
import com.eshop.ordering.domain.events.DraftOrderItemAdded;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Data // Lombok
@NoArgsConstructor // Lombok
@AllArgsConstructor // Lombok
@Entity
@Table(name="Orders")
public class Order extends AbstractAggregateRoot<Order> {

    @Id
    // @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long buyerId;

    @JsonManagedReference 
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItems> items;

    public Order(Long buyerId, List<OrderItems> items) {
        this.buyerId = buyerId;
        this.items = items;

        this.items.forEach(item -> item.setOrder(this));

        this.registerEvent(new DraftOrderCreated(this));
    }

    public void AddOrderItems(List<OrderItems> items){

        this.items.addAll(items);
        
        this.registerEvent(new DraftOrderItemAdded(this));
    }
}
