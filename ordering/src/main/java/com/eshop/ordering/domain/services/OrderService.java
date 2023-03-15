package com.eshop.ordering.domain.services;

public interface OrderService {
    
    // The problem is havong methods that use the domain, when we want to accept commands from the controller
    // So having operations here that use the domain would mean that we need to receive DTOs not Commands
    // and then convert the DTOs into Commands, and no we're not doing that LOL
}
