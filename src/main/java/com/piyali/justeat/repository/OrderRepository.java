package com.piyali.justeat.repository;

import com.piyali.justeat.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {

    Optional<Order> getOrderByOrderId(String id);
    List<Order> getAllByUser_UserName(String username);
}
