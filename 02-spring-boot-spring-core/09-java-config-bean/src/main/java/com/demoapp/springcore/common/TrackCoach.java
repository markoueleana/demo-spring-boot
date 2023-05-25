package com.demoapp.springcore.common;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach {
    public TrackCoach() {
        System.out.println("TrackCoach Constructor " + getClass().getName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K!";
    }
}
