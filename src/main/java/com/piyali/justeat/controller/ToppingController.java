package com.piyali.justeat.controller;
import com.piyali.justeat.model.Order;
import com.piyali.justeat.service.ToppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/api/topping")
public class ToppingController {
    private final ToppingService toppingService;



/*    @RequestMapping(value= "/orderListPage", method = RequestMethod.GET)
    public String showCustomerPage(Model model, @RequestParam("username") String username){
        List<Order> orderList = orderService.getAllOrderByUserName(username);
        model.addAttribute("orders",orderList);
        return "orderListPage";
    }*/

}
