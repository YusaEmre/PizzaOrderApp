package com.piyali.justeat.controller;
import com.piyali.justeat.model.Topping;
import com.piyali.justeat.payload.request.ToppingEditRequest;
import com.piyali.justeat.service.ToppingService;
import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/api/topping")
public class ToppingController {
    private final ToppingService toppingService;

    public ToppingController(ToppingService toppingService) {
        this.toppingService = toppingService;
    }



    @RequestMapping(value= "/toppingListPage", method = RequestMethod.GET)
    public ModelAndView showToppingListPage(@RequestParam("username") String username){
        List<Topping> toppingList = toppingService.getAllToppings();
        ModelAndView modelAndView = new ModelAndView("toppingListPage");
        modelAndView.addObject("toppings",toppingList);
        modelAndView.addObject("username",username);
        return modelAndView;
    }



    @RequestMapping(value= "/toppingEditPage", method = RequestMethod.GET)
    public ModelAndView showToppingEditPage(@RequestParam("username") String username,@RequestParam(name = "toppingId") Long toppingId){
        Topping topping = toppingService.getToppingById(toppingId);
        ModelAndView modelAndView = new ModelAndView("editTopping");
        modelAndView.addObject("topping",topping);
        modelAndView.addObject("username",username);
        return modelAndView;
    }


    @RequestMapping(value = "/updateTopping",method = RequestMethod.POST)
    public ModelAndView updateTopping(@RequestParam("username")String username ,@ModelAttribute("ToppingEditRequest")ToppingEditRequest toppingEditRequest){
        toppingService.updateTopping(toppingEditRequest);
        List<Topping> toppingList = toppingService.getAllToppings();
        ModelAndView modelAndView = new ModelAndView("toppingListPage");
        modelAndView.addObject("username",username);
        modelAndView.addObject("toppings",toppingList);
        return modelAndView;
    }
}
