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

//Order related endpoints
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


    // Creates new order and returns order detail page
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public ModelAndView addOrder(@ModelAttribute("OrderAddRequest") OrderAddRequest request){
        Order order = orderService.saveOrder(request);

        ModelAndView modelAndView = new ModelAndView("orderDetailPage");
        modelAndView.addObject("username",order.getUser().getUserName());
        modelAndView.addObject("order",order);
        return modelAndView;
    }

    // Returns order creating page
    @RequestMapping(value = "/placeOrder",method = RequestMethod.GET)
    public ModelAndView placeOrderPage(@RequestParam String username){
        User user = userService.findByName(username);
        List<Topping> toppings = toppingService.getAllToppings();
        ModelAndView modelAndView = new ModelAndView("placeOrderPage");
        modelAndView.addObject("user",user);
        modelAndView.addObject("toppings",toppings);
        return modelAndView;
    }


    // Returns order editing page
    @RequestMapping(value = "/editOrderPage",method = RequestMethod.GET)
    public ModelAndView editOrderPage(@RequestParam("orderId") Long orderId,@RequestParam("username")String username){
        Order order = orderService.getOrderById(orderId);
        List<Topping> toppings = toppingService.getAllToppings();
        ModelAndView modelAndView = new ModelAndView("orderEditPage");
        modelAndView.addObject("username",username);
        modelAndView.addObject("order",order);
        modelAndView.addObject("toppings",toppings);
        return modelAndView;
    }

    // İf user is an admin returns orders of all users is user is a customer returns customer orders
    @RequestMapping(value= "/orderListPage", method = RequestMethod.GET)
    public ModelAndView showOrderListPage(@RequestParam("username") String username){
        ModelAndView modelAndView = new ModelAndView("orderListPage");
        User user = userService.findByName(username);
        if(user.getAdmin()){
            List<Order> orderList = orderService.getAllOrder();
            modelAndView.addObject("orders",orderList);
        }
        else {
            List<Order> orderList = user.getOrderList();
            modelAndView.addObject("orders",orderList);
        }
        return modelAndView;
    }

    //Updates the topping of an order
    @RequestMapping(value = "/updateOrder",method = RequestMethod.POST)
    public ModelAndView editOrderPage(@RequestParam("username")String username,@ModelAttribute("OrderEditRequest") OrderEditRequest orderEditRequest){
        orderService.updateOrder(orderEditRequest);
        User user = userService.findByName(username);
        List<Order> orderList;
        if(user.getAdmin()){
            orderList  = orderService.getAllOrder();
        }else{
            orderList = user.getOrderList();
        }
        ModelAndView modelAndView = new ModelAndView("orderListPage");
        modelAndView.addObject("orders",orderList);
        modelAndView.addObject("username",username);
        return modelAndView;
    }



    @RequestMapping(value = "/orderDetailPage",method = RequestMethod.GET)
    public ModelAndView addOrder(@RequestParam(value = "orderId") Long orderId,@RequestParam("username")String username){

        ModelAndView modelAndView = new ModelAndView("orderDetailPage");
        modelAndView.addObject("username",username);
        User user = userService.findByName(username);
        try{
            Order order = orderService.getOrderById(orderId);
            modelAndView.addObject("order",order);
        }
        catch (Exception e){
            List<Order> orderList;
            if(user.getAdmin()){
                orderList = orderService.getAllOrder();
            }else{
                orderList = user.getOrderList();
            }
            modelAndView.addObject("orders",orderList);
            modelAndView.setViewName("orderListPage");
            modelAndView.addObject("error",e.getMessage());
        }
        return modelAndView;
    }

    // Deletes the order and returns the order list back
    @RequestMapping(value = "/deleteOrder/{orderId}",method = RequestMethod.GET)
    public ModelAndView deleteOrder(@PathVariable(value = "orderId") Long orderId,@RequestParam("username")String username){
        orderService.deleteOrder(orderId);
        return showOrderListPage(username);
    }
}
