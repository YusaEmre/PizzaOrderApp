package com.piyali.justeat.controller;

import com.piyali.justeat.model.Order;
import com.piyali.justeat.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    //call order service
    private final OrderService orderService;

    /*
    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder(Model model){
        return orderService.saveOrder();
    }
     */

    @GetMapping("/getAllOrder")
    public ResponseEntity<List<Order>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }

    @GetMapping("/getOrderByOrderId/{orderId}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable Long orderId){
        return ResponseEntity.ok(orderService.getOrderByOrderId(orderId));
    }

}
