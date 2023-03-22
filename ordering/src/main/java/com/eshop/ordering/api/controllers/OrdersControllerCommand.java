package com.eshop.ordering.api.controllers;

import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.eshop.ordering.application.commands.AddItemsToOrderCommand;
import com.eshop.ordering.application.commands.CreateOrderDraftCommand;
import com.eshop.ordering.application.services.OrderService;

import org.springframework.validation.FieldError;

import jakarta.validation.Valid;
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
    public ResponseEntity<String> CreateDraftOrder(
            @Valid @RequestBody(required = true) CreateOrderDraftCommand command) {

        this.service.handleCreateOrderDraftCommand(command);

        String response = "Done.";

        log.info(response);

        return ResponseEntity.ok(response);
    }




    @PutMapping(path = "/draft/items")
    public ResponseEntity<String> AddItemsToDraftOrder(
            @Valid @RequestBody(required = true) AddItemsToOrderCommand command) throws Exception {

        this.service.handleAddItemsToOrderCommand(command);

        String response = "Done.";

        log.info(response);

        return ResponseEntity.ok(response);
    }




    /*
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName, errorMessage);
            });
        return errors;
    }
    */
}
