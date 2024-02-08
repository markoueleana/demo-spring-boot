package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {
    @Before("com.aopdemo.aspect.AopExpressions.forDaoPackage()")
    public void beforeAddAccount(JoinPoint theJoinPoint) {
        MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();
        Object[] args=  theJoinPoint.getArgs();
        System.out.println("==>> My first @Before advice. This method has the signature: "+ signature);
        for (Object arg : args){
            if (arg instanceof Account){
                Account theAccount =(Account) arg;
                System.out.println("==>> Instance of Account with name: "+ theAccount.getName()+" and level: "+ theAccount.getLevel());
            }
        }
    }


}
