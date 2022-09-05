package com.piyali.justeat.repository;

import com.piyali.justeat.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,String> {

    Optional<Order> getOrderByOrderId(String id);
    List<Order> getAllByUser_UserName(String username);
}
