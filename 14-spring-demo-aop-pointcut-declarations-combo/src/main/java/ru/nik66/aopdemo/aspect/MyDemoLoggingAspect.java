package ru.nik66.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* ru.nik66.aopdemo.dao.*.get*())")
    public void getter() {}

    @Pointcut("execution(* ru.nik66.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("execution(* ru.nik66.aopdemo.dao.*.*(..))")
    public void doForDAOPackage() {}

    @Pointcut("doForDAOPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("===> Executing @Before advice on addAccount()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("===> Performing API analitycs");
    }

}
