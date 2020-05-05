package ru.nik66.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Before("execution(public void ru.nik66.aopdemo.dao.*.add*())")
    public void beforeAddAccountAdvice() {
        System.out.println("===> Executing @Before advice on addAccount()");
    }

}
