package com.eshop.ordering.application.commands;

import java.util.Collection;

import lombok.*;

@Data               // Lombok
@AllArgsConstructor // Lombok
public class CreateOrderDraftCommand {
    
    private Long buyerId;
    private Collection<CreateOrderItemDraftCommand> items;
}
