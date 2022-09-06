package com.piyali.justeat.controller;
import com.piyali.justeat.exception.NotFoundException;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView editOrderPage(@RequestParam("orderId") Long orderId){
        Order order = orderService.getOrderById(orderId);
        List<Topping> toppings = toppingService.getAllToppings();
        ModelAndView modelAndView = new ModelAndView("orderEditPage");
        modelAndView.addObject("order",order);
        modelAndView.addObject("toppings",toppings);
        return modelAndView;
    }
    @RequestMapping(value= "/orderListPage", method = RequestMethod.GET)
    public ModelAndView showOrderListPage(@RequestParam("username") String username){
        ModelAndView modelAndView = new ModelAndView("orderListPage");
        User user = userService.findByName(username);
        if(user.getAdmin()){
            List<Order> orderList = orderService.getAllOrder();
            modelAndView.addObject("orders",orderList);
        }
        else {
            List<Order> orderList = userService.findByName(username).getOrderList();
            modelAndView.addObject("orders",orderList);
        }

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


    @RequestMapping(value = "/orderDetailPage",method = RequestMethod.GET)
    public ModelAndView addOrder(@RequestParam("orderId") Long orderId,
                                 RedirectAttributes redirectAttributes){
        ModelAndView modelAndView = new ModelAndView();
        try{
            Order order = orderService.getOrderById(orderId);
            modelAndView.addObject("order",order);
            modelAndView.setViewName("orderDetailPage");
        }
        catch (Exception e){
            modelAndView.setViewName("orderListPage");
            redirectAttributes.addFlashAttribute("error",e.getMessage());
        }
        return modelAndView;
    }

    @RequestMapping(value = "/deleteOrder/{orderId}",method = RequestMethod.GET)
    public ModelAndView deleteOrder(@PathVariable(value = "orderId") Long orderId){
        String username = orderService.getOrderById(orderId).getUser().getUserName();
        orderService.deleteOrder(orderId);
        return showOrderListPage(username);
    }


}
