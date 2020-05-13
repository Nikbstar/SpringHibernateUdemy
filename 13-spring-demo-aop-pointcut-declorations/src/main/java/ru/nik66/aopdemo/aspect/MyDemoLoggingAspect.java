package ru.nik66.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* ru.nik66.aopdemo.dao.*.*(..))")
    public void doForDAOPackage() {}

    @Before("doForDAOPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("===> Executing @Before advice on addAccount()");
    }

    @Before("doForDAOPackage()")
    public void performApiAnalytics() {
        System.out.println("===> Performing API analitycs");
    }

}
