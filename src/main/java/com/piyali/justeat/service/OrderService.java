package com.piyali.justeat.service;

import com.piyali.justeat.model.Order;
import com.piyali.justeat.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderByOrderId(String orderId) {
        return orderRepository.getOrderByOrderId(orderId);
    }
}
