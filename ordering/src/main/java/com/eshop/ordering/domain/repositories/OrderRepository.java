package com.eshop.ordering.domain.repositories;

import com.eshop.ordering.domain.Order;

public interface OrderRepository {

    void save(Order order);
}
