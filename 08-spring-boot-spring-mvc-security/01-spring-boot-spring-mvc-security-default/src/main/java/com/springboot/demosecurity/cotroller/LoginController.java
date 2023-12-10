package com.springboot.demosecurity.cotroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping("/showMyLoginPage")
    public String showLoginPage(){
        return "login-page";
    }
    @GetMapping("/access-denied")
    public String showAccessDeniedPage(){
        return "access-denied-page";
    }


}
