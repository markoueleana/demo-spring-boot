package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {

    @AfterReturning(pointcut = "execution (* com.aopdemo.dao.AccountDAO.findAccounts(..))",returning = "results")
    public void afterReturningAdvice(JoinPoint theJoinPoint, List<Account> results) {
        System.out.println("==>> My first @AfterReturning advice. THE RESULTS ARE : "+results);
        convertNamesToUpperCase(results);

        System.out.println("==>> My first @AfterReturning advice. THE MODIFIED RESULTS ARE : "+results);
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
