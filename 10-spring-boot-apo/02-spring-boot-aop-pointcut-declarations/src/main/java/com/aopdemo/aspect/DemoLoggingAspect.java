package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {
    @Pointcut("execution ( * com.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution ( * com.aopdemo.dao.*.get*(..))")
    private void getter() {}
    @Pointcut("execution ( * com.aopdemo.dao.*.set*(..))")
    private void setter() {}
    @Pointcut("forDaoPackage() && (setter() || getter())")
    private void forDaoPackageSetterOrGetter() {}
    @Pointcut("forDaoPackage() && !(setter() || getter())")
    private void forDaoPackageWithoutSetterOrGetter() {}
    @Before("forDaoPackage()")
    public void beforeAddAccount() {
        System.out.println("==>> My first @Before advice ");
    }
    @Before("forDaoPackage()")
    public void performAnalytics() {
        System.out.println("==>> My @Before perform Analytics ");
    }
    @Before("forDaoPackageSetterOrGetter()")
    public void getterOrSetterInTheDaoPackage() {
        System.out.println("==>> My @Before getter Or Setter ");
    }@Before("forDaoPackageWithoutSetterOrGetter()")
    public void noGetterOrSetterInTheDaoPackage() {
        System.out.println("==>> My @Before Without getter Or Setter ");
    }
}
