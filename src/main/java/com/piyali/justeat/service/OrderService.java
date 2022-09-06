package com.piyali.justeat.service;

import com.piyali.justeat.exception.NotFoundException;
import com.piyali.justeat.model.Order;
import com.piyali.justeat.model.Topping;
import com.piyali.justeat.model.User;
import com.piyali.justeat.payload.request.OrderAddRequest;
import com.piyali.justeat.payload.request.OrderEditRequest;
import com.piyali.justeat.repository.OrderRepository;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class OrderService {

    private final UserService userService;

    private final ToppingService toppingService;
    private final OrderRepository orderRepository;

    public OrderService(UserService userService, ToppingService toppingService, OrderRepository orderRepository) {
        this.userService = userService;
        this.toppingService = toppingService;
        this.orderRepository = orderRepository;
    }


    public Order saveOrder(OrderAddRequest request) {
        User user =userService.findById(request.getCustomerId());
        Topping topping = toppingService.getToppingByPrice(request.getToppingPrice());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Order order = new Order(request.getTotalPrice(),topping,user,LocalDate.parse(request.getDeliveryDate(),dateTimeFormatter));
        orderRepository.save(order);
        user.getOrderList().add(order);
        orderRepository.flush();
        return order;
    }


    public Order getOrderById(Long orderId){
        return orderRepository.getOrderByOrderId(orderId).orElseThrow(()-> new NotFoundException("Order not found"));
    }

    public void updateOrder(OrderEditRequest request) {
        Order order = orderRepository.findById(request.getOrderId()).orElseThrow(()-> new NotFoundException("Order not found"));
        Topping topping = toppingService.getToppingByPrice(request.getToppingPrice());
        order.setTopping(topping);
        orderRepository.flush();
    }

    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    public void deleteOrder(Long orderId){
        Order order = getOrderById(orderId);
        User user = order.getUser();
        user.getOrderList().remove(order);
        orderRepository.deleteById(orderId);
        orderRepository.flush();
    }

}
