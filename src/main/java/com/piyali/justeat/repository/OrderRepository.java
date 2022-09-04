package com.piyali.justeat.repository;

import com.piyali.justeat.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,String> {

    Order getOrderByOrderId(String id);
}
