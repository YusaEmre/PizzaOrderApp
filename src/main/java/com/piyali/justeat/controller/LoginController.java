package com.piyali.justeat.controller;

import com.piyali.justeat.Service.LoginService;
import com.piyali.justeat.exception.NotFoundException;
import com.piyali.justeat.payload.request.LoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Controller
@SessionAttributes("name")
public class LoginController {


    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value= {"/login",""}, method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
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

}