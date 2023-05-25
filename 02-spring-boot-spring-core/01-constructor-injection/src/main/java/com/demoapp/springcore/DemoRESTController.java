package com.demoapp.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRESTController {

    //define private field for dependency
    private Coach myCoach;

    @Autowired
    public DemoRESTController(Coach theCoach){
        myCoach=theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDaukyWorkout(){
        return myCoach.getDailyWorkout();
    }

}
