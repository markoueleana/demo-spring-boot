package com.demoapp.springcore.common;

public class SwimCoach implements  Coach{
    public SwimCoach(){
        System.out.println("In the SwimCoach constructor");
    }
    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
