package com.piyali.justeat.service;

import com.piyali.justeat.model.Order;
import com.piyali.justeat.model.User;
import com.piyali.justeat.payload.request.OrderAddRequest;
import com.piyali.justeat.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final UserService userService;
    private final OrderRepository orderRepository;
    public Order saveOrder(OrderAddRequest request) {
        User user =userService.findById(request.getCustomerId());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Order order = new Order().toBuilder()
                .deliveryDate(LocalDate.parse(request.getDeliveryDate(),dateTimeFormatter))
                .topping(request.getTopping())
                .totalPrice(request.getTotalPrice())
                .user(user)
                .build();
        return orderRepository.save(order);
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Order getOrderByOrderId(String orderId) {
        return orderRepository.getOrderByOrderId(orderId);
    }
}
