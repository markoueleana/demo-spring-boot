package com.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImp implements TrafficFortuneService{
    @Override
    public String getFortune() {
        try{
            TimeUnit.SECONDS.sleep(4);
        }catch(InterruptedException exception){
            throw new RuntimeException(exception);
        }

        return "Except heavy traffic!";
    }

    @Override
    public String getFortune(boolean tripWire) {
       if (tripWire){
           throw  new RuntimeException("Major accident! Highway closed");
       }
        return getFortune();
    }
}
