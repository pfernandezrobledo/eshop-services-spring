package com.eshop.ordering.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.*;

@Data               // Lombok
@NoArgsConstructor  // Lombok
@AllArgsConstructor // Lombok
@Entity
@Table(name="OrderItems")
public class OrderItems {
    
    @Id
    // @SequenceGenerator(name = "order_item_sequence", sequenceName = "order_item_sequence", allocationSize = 1)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_item_sequence")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    // private String productUrl;
    private Float unitPriice;
    // private Float discount;
    private Integer units;

    @JsonBackReference
    // https://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    public OrderItems(String productName, Float unitPriice, Integer units, Order order) {
        this.productName = productName;
        this.unitPriice = unitPriice;
        this.units = units;
        this.order = order;
    }
}
