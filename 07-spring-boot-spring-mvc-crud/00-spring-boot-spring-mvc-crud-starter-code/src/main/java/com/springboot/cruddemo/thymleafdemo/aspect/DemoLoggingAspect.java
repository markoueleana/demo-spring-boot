package com.springboot.cruddemo.thymleafdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {
    public Logger logger= Logger.getLogger(getClass().getName());

    @Pointcut("execution (* com.springboot.cruddemo.thymleafdemo.controller.*.*(..))")
    public void forControllerPackage(){}
    @Pointcut("execution (* com.springboot.cruddemo.thymleafdemo.service.*.*(..))")
    public void forServicePackage(){}
    @Pointcut("execution (* com.springboot.cruddemo.thymleafdemo.dao.*.*(..))")
    public void forDaoPackage(){}
    @Pointcut("forDaoPackage() || forServicePackage()|| forControllerPackage()")
    public void forAppFlow(){}
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().toShortString();
        logger.info("==> in @Before, calling method : "+methodName);
        Object[] args= joinPoint.getArgs();
        for(Object a:args){
            logger.info("==> Argument: "+a);

        }

    }
    @AfterReturning(pointcut = "forAppFlow()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        String methodName=joinPoint.getSignature().toShortString();
        logger.info("==> in @AfterReturning, calling method : "+methodName);

        logger.info("==> the result is : "+ result);
    }
}
