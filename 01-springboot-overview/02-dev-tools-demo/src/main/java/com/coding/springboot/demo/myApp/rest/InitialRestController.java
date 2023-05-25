package com.coding.springboot.demo.myApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialRestController {
/*    expose thath return Hello World*/
    @Value("${my.name}")
    public String name ;
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello cccWorld";
    }
    @GetMapping("/hello/eleana")
    public String sayHelloName(){
        return "Hello "+ name;
    }
}
