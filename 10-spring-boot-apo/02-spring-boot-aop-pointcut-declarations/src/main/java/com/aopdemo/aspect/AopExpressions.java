package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
    @Pointcut("execution ( * com.aopdemo.dao.*.*(..))")
    protected void forDaoPackage() {}
    @Pointcut("execution ( * com.aopdemo.dao.*.get*(..))")
    protected void getter() {}
    @Pointcut("execution ( * com.aopdemo.dao.*.set*(..))")
    protected void setter() {}
    @Pointcut("forDaoPackage() && (setter() || getter())")
    protected void forDaoPackageSetterOrGetter() {}
    @Pointcut("forDaoPackage() && !(setter() || getter())")
    protected void forDaoPackageWithoutSetterOrGetter() {}
}
