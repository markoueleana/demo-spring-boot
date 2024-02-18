package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {
    @After( "execution (* com.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterAdvice(JoinPoint theJoinPoint) {
        System.out.println("==>> My first @After advice.");

    }
    @AfterReturning(pointcut = "execution (* com.aopdemo.dao.AccountDAO.findAccounts(..))",returning = "results")
    public void afterReturningAdvice(JoinPoint theJoinPoint, List<Account> results) {
        System.out.println("==>> My first @AfterReturning advice. THE RESULTS ARE : "+results);
        convertNamesToUpperCase(results);

        System.out.println("==>> My first @AfterReturning advice. THE MODIFIED RESULTS ARE : "+results);
    }
    @AfterThrowing(pointcut = "execution (* com.aopdemo.dao.AccountDAO.findAccounts(..))",throwing = "theException")
    public void afterReturningAdvice(JoinPoint theJoinPoint, Throwable theException) {
        String methodName= theJoinPoint.getSignature().toShortString();
        System.out.println("==>> My first @AfterThrowing advice. THE METHOD :"+methodName+" THREW AN EXCEPTION ARE : "+theException);

    }

    private void convertNamesToUpperCase(List<Account> results) {
        for(Account acc : results){

            acc.setName( acc.getName().toUpperCase());
        }
    }

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
