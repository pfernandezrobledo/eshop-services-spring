package com.eshop.ordering.application.commands;

import java.util.Collection;

import jakarta.validation.constraints.*;
import lombok.*;

@Data               // Lombok
@AllArgsConstructor // Lombok
public class CreateOrderDraftCommand {
    
    @NotNull(message = "The buyer ID is required.")
    @Min(value = 1, message = "The buyer ID value is not valid.")
    private Long buyerId;

    @NotEmpty(message = "The list of order items cannot be empty.")
    private Collection<OrderItemDraftCommand> items;
}
