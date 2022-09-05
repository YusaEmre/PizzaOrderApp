package com.piyali.justeat.controller;
import com.piyali.justeat.model.Topping;
import com.piyali.justeat.model.User;
import com.piyali.justeat.payload.request.OrderAddRequest;
import com.piyali.justeat.payload.request.OrderEditRequest;
import com.piyali.justeat.service.OrderService;
import com.piyali.justeat.model.Order;
import com.piyali.justeat.service.ToppingService;
import com.piyali.justeat.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/api/order")
public class OrderController {

    //call order service
    private final OrderService orderService;
    private final UserService userService;

    private final ToppingService toppingService;

    public OrderController(OrderService orderService, UserService userService, ToppingService toppingService) {
        this.orderService = orderService;
        this.userService = userService;
        this.toppingService = toppingService;
    }

    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public ModelAndView addOrder(@ModelAttribute("OrderAddRequest") OrderAddRequest request){
        Order order = orderService.saveOrder(request);
        ModelAndView modelAndView = new ModelAndView("orderDetailPage");
        modelAndView.addObject("order",order);
        return modelAndView;
    }

    @RequestMapping(value = "/placeOrder",method = RequestMethod.GET)
    public ModelAndView placeOrderPage(@RequestParam String username){
        User user = userService.findByName(username);
        List<Topping> toppings = toppingService.getAllToppings();
        ModelAndView modelAndView = new ModelAndView("placeOrderPage");
        modelAndView.addObject("user",user);
        modelAndView.addObject("toppings",toppings);
        return modelAndView;
    }

    @RequestMapping(value = "/editOrderPage",method = RequestMethod.GET)
    public ModelAndView editOrderPage(@RequestParam("orderId") String orderId){
        Order order = orderService.getOrderById(orderId);
        List<Topping> toppings = toppingService.getAllToppings();
        ModelAndView modelAndView = new ModelAndView("orderEditPage");
        modelAndView.addObject("order",order);
        modelAndView.addObject("toppings",toppings);
        return modelAndView;
    }
    @RequestMapping(value= "/orderListPage", method = RequestMethod.GET)
    public ModelAndView showCustomerPage(@RequestParam("username") String username){
        List<Order> orderList = userService.findByName(username).getOrderList();
        ModelAndView modelAndView = new ModelAndView("orderListPage");
        modelAndView.addObject("orders",orderList);
        System.out.println(orderList.size());
        return modelAndView;
    }

    @RequestMapping(value = "/updateOrder",method = RequestMethod.POST)
    public ModelAndView editOrderPage(@RequestParam("username")String username,@ModelAttribute("OrderEditRequest") OrderEditRequest orderEditRequest){
        orderService.updateOrder(orderEditRequest);
        List<Order> orderList = userService.findByName(username).getOrderList();
        ModelAndView modelAndView = new ModelAndView("orderListPage");
        modelAndView.addObject("orders",orderList);
        modelAndView.addObject("username",username);
        return modelAndView;
    }

}
