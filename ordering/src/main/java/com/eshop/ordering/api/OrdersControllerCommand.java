package com.eshop.ordering.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.ordering.application.commands.CreateOrderDraftCommand;
import com.eshop.ordering.application.services.OrderService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "api/orders/cmd")
@Slf4j
public class OrdersControllerCommand {

    private OrderService service;

    @Autowired
    public OrdersControllerCommand(OrderService service) {
        this.service = service;
    }

    @GetMapping("/testing")
    public ResponseEntity<String> Testing() {

        String response = "Testing: Response Message";

        return ResponseEntity.ok(response);
    }

    @PostMapping(path = "/draft")
    public ResponseEntity<String> CreateOrderDraftFromBasket(
            @RequestBody(required = true) CreateOrderDraftCommand command) {

        this.service.handleCreateOrderDraftCommand(command);

        String response = "Done.";
        
        log.info(response);

        return ResponseEntity.ok(response);
    }
}
