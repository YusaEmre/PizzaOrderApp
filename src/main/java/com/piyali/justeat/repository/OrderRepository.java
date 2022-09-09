package com.piyali.justeat.repository;

import com.piyali.justeat.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//Jpa repository contains a lot of ready to use functions, jpa creates  sql queries with hibernate
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    Optional<Order> getOrderByOrderId(Long id);
    List<Order> getAllByUser_UserName(String username);
}
