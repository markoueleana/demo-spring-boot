package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiLogAspect {

    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void apiLog() {
        System.out.println("==>> My api Log advice ");
    }
}
