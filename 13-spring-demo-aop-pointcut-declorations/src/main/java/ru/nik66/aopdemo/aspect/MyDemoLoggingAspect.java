package ru.nik66.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(* ru.nik66.aopdemo.dao.*.*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("===> Executing @Before advice on addAccount()");
    }

    @Before("execution(* ru.nik66.aopdemo.dao.*.*(..))")
    public void anotherBefore() {
        System.out.println("===> This is another @Before advice");
    }

}
