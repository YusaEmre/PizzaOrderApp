package com.piyali.justeat.repository;

import com.piyali.justeat.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {

    Order getOrderByOrderId(String id);
    List<Order> getAllByUser_UserName(String username);
}
