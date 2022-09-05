package com.piyali.justeat.controller;
import com.piyali.justeat.service.ToppingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/topping")
public class ToppingController {
    private final ToppingService toppingService;

    public ToppingController(ToppingService toppingService) {
        this.toppingService = toppingService;
    }



/*    @RequestMapping(value= "/orderListPage", method = RequestMethod.GET)
    public String showCustomerPage(Model model, @RequestParam("username") String username){
        List<Order> orderList = orderService.getAllOrderByUserName(username);
        model.addAttribute("orders",orderList);
        return "orderListPage";
    }*/

}
