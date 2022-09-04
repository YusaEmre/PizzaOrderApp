package com.piyali.justeat.Service;

import com.piyali.justeat.model.Order;
import com.piyali.justeat.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.omg.CORBA.Object;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        orderRepository.save(order);
        return order;
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderByOrderId(Long orderId) {
        return  orderRepository.findById(orderId).orElseThrow(()->new IllegalStateException("Order not found"));
    }
}
