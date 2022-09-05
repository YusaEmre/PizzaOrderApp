package com.piyali.justeat.controller;

import com.piyali.justeat.model.User;
import com.piyali.justeat.service.LoginService;
import com.piyali.justeat.payload.request.LoginRequest;
import com.piyali.justeat.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@SessionAttributes("name")


public class LoginController {

    private  final UserService userService;
    private final LoginService loginService;

    public LoginController(UserService userService, LoginService loginService) {
        this.userService = userService;
        this.loginService = loginService;
    }





    @RequestMapping(value= {"/login",""}, method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public ModelAndView showHomePage(@ModelAttribute("loginRequest") LoginRequest loginRequest,
                                     RedirectAttributes redirectAttributes)  {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username",loginRequest.getUsername());
        try {
            boolean isAdmin =  loginService.validateUser(loginRequest);
            if(isAdmin){
                modelAndView.setViewName("adminPage");
            }else{
                modelAndView.setViewName("customerPage");
            }
            return modelAndView;
        }catch (Exception e){
            modelAndView.setViewName("redirect:/login");
            redirectAttributes.addFlashAttribute("error",e.getMessage());
            return modelAndView;
        }
    }
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView showHomePage(@RequestParam("username") String username)  {
        User user = userService.findByName(username);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username",username);
        if(user.getAdmin()){
            modelAndView.setViewName("adminPage");
        }else{
            modelAndView.setViewName("customerPage");
        }
        return modelAndView;
    }



}