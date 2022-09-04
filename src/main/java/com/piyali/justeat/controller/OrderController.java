package com.piyali.justeat.controller;
import com.piyali.justeat.service.OrderService;
import com.piyali.justeat.model.Order;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    //call order service
    private final OrderService orderService;

    @RequestMapping(value= "/orderListPage", method = RequestMethod.GET)
    public String showCustomerPage(Model model, @RequestParam("username") String username){
        List<Order> orderList = orderService.getAllOrderByUserName(username);
        model.addAttribute("orders",orderList);
        return "orderListPage";
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Order> addOrder(Order order){
        return ResponseEntity.ok(orderService.saveOrder(order));
    }


    @GetMapping("/getAllOrder")
    public ResponseEntity<List<Order>> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrder());
    }

}
