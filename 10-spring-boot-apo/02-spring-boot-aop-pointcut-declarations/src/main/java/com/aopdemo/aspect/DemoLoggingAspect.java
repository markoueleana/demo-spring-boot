package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {
    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void beforeAddAccount() {
        System.out.println("==>> My first @Before advice ");
    }


}