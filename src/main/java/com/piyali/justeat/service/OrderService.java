package com.piyali.justeat.service;

import com.piyali.justeat.exception.NotFoundException;
import com.piyali.justeat.model.Order;
import com.piyali.justeat.model.Topping;
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

    private final ToppingService toppingService;
    private final OrderRepository orderRepository;



    public Order saveOrder(OrderAddRequest request) {
        User user =userService.findById(request.getCustomerId());
        Topping topping = toppingService.getToppingByPrice(request.getToppingPrice());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Order order = new Order().toBuilder()
                .deliveryDate(LocalDate.parse(request.getDeliveryDate(),dateTimeFormatter))
                .topping(topping)
                .totalPrice(request.getTotalPrice())
                .user(user)
                .build();

        orderRepository.save(order);
        user.getOrderList().add(order);
        orderRepository.flush();
        return order;
    }

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public List<Order> getAllOrderByUserName(String username) {

        return orderRepository.getAllByUser_UserName(username);
    }


    public Order getOrderById(String orderId){
        return orderRepository.getOrderByOrderId(orderId).orElseThrow(()-> new NotFoundException("Order not found"));
    }
}
