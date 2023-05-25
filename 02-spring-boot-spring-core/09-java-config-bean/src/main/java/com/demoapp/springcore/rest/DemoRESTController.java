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

    @Autowired
    public void setCoach(@Qualifier("inTheWater") Coach theCoach) {
        myCoach = theCoach;

    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
