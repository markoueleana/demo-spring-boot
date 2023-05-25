package com.coding.springboot.demo.myApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialRestController {
/*    expose th
ath return Hello World*/
    @Value("${my.name}")
    public String name ;
    @Value("${name.leader}")
    public String leaderName ;
    @Value("${team.name}")
    public String teamName ;
    @GetMapping("/")
    public String sayHello(){
        return "Hello World";
    }
    @GetMapping("/hello/name")
    public String sayHelloName(){
        return "Hello "+ name ;
    }
    @GetMapping("/team")
    public String sayTeamInfo(){
        return "Hello "+ name + " the leader's name is " + leaderName+ " the name of the team is " +teamName;
    }
}
