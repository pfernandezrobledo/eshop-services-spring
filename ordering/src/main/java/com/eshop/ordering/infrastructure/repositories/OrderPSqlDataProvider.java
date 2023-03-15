package com.eshop.ordering.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eshop.ordering.domain.*;

@Repository
public interface OrderPSqlDataProvider extends JpaRepository<Order, Long> {
    
}
