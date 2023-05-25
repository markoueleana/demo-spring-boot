package com.demoapp.springcore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demoapp.springcore.common.Coach;

@RestController
public class DemoRESTController {

    //define private field for dependency
    private Coach myCoach;
    private Coach anotherCoach;
    @Autowired
    public void setCoach(@Qualifier("cricketCoach") Coach theCoach,
                         @Qualifier("cricketCoach") Coach theAnotherCoach){
        myCoach=theCoach;
        anotherCoach=theAnotherCoach;

    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/checkscope")
    public String getScope(){
        return  "Is cricketCoach of scope singleton? " + (myCoach == anotherCoach);
    }
}
