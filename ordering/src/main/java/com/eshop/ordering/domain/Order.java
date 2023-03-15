package com.eshop.ordering.domain;

import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.*;

@Data // Lombok
@NoArgsConstructor // Lombok
@AllArgsConstructor // Lombok
@Entity
@Table(name="Orders")
public class Order {

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
    }
}
