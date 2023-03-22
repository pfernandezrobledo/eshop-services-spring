package com.eshop.ordering.application.commands;

import org.hibernate.validator.constraints.Currency;

import jakarta.validation.constraints.*;
import lombok.*;

@Data               // Lombok
@AllArgsConstructor // Lombok
public class OrderItemDraftCommand {
    
    @NotEmpty(message = "The product ID is required.")
    @Min(value = 1, message = "The product ID value is not valid.")
    private Long productId;

    @NotEmpty(message = "The product name is required.")
    private String productName;

    // private String productUrl;
    @NotEmpty(message = "The unit price is required.")
    @Min(value = 0)
    private Float unitPrice;
    // private Float discount;
    @NotEmpty(message = "The unit count is required.")
    @Min(value = 0)
    private Integer units;
}
