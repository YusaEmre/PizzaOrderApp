package com.piyali.justeat.controller;

import com.piyali.justeat.Service.LoginService;
import com.piyali.justeat.payload.request.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@SessionAttributes("name")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @RequestMapping(value= {"/login",""}, method = RequestMethod.GET)
    public String showLoginPage(){
        return "login";
    }

    @RequestMapping(value = "/home",method = RequestMethod.POST)
    public String showWelcomePage(@ModelAttribute("loginRequest") LoginRequest loginRequest){

       return loginService.validateUser(loginRequest) ? "registered" : "redirect:/login";
    }

}