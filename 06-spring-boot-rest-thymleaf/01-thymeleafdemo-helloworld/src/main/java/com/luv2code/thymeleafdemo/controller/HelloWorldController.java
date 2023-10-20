package com.luv2code.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    @GetMapping("/showForm")
    public String showFrom(){
        return "helloworld-form";
    }


    @PostMapping("/processForm-V3")
    public String processFormV3(@RequestParam ("studentName") String theName, Model model){

        model.addAttribute("message","The is the name "+ theName);
        return "helloworld";
    }
}
