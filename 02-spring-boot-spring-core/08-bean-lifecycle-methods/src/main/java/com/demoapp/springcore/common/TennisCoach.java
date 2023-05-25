package com.demoapp.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    public TennisCoach(){
        System.out.println("TennisCoach Constructor "+ getClass().getName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice you backhand volley";
    }
}
