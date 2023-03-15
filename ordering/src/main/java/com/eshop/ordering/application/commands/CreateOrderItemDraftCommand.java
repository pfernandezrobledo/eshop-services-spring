package com.eshop.ordering.application.commands;

import lombok.*;

@Data               // Lombok
@AllArgsConstructor // Lombok
public class CreateOrderItemDraftCommand {
    
    private Long productId;
    private String productName;
    // private String productUrl;
    private Float unitPrice;
    // private Float discount;
    private Integer units;
}
