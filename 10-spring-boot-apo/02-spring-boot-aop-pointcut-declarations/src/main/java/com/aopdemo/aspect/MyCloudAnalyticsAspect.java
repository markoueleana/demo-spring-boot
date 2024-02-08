package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudAnalyticsAspect {

    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackageWithoutSetterOrGetter()")
    public void logToCloudAnalytics() {
        System.out.println("==>> My @Before log To Cloud Analytics ");
    }
}
