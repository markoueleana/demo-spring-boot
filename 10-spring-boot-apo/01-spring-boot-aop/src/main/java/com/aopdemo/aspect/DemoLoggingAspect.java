package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    @Before("execution (public void add*() )")
    public void beforeAddAccount(){
        System.out.println("My first @Before advice ");
    }
}
