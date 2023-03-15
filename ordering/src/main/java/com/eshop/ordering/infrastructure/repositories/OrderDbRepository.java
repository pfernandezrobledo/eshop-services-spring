package com.eshop.ordering.infrastructure.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.eshop.ordering.domain.Order;
import com.eshop.ordering.domain.repositories.*;

@Component
@Primary
public class OrderDbRepository implements OrderRepository {

    private OrderPSqlDataProvider dataProvider;

    @Autowired
    public OrderDbRepository(OrderPSqlDataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    @Override
    public void save(Order order) {
        
        this.dataProvider.save(order);

    }

}
