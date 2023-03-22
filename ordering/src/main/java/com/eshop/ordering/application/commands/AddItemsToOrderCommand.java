package com.eshop.ordering.application.commands;

import java.util.Collection;

import jakarta.validation.constraints.*;
import lombok.*;

@Data               // Lombok
@AllArgsConstructor // Lombok
public class AddItemsToOrderCommand {
    
    @NotNull(message = "The order ID is required.")
    private Long orderId;

    @NotNull(message = "The buyer ID is required.")
    private Long buyerId;

    @NotEmpty(message = "The list of order items cannot be empty.")
    private Collection<OrderItemDraftCommand> items;
}
