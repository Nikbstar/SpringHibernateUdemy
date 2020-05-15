package ru.nik66.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {

    @Pointcut("execution(* ru.nik66.aopdemo.dao.*.get*())")
    public void getter() {}

    @Pointcut("execution(* ru.nik66.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("execution(* ru.nik66.aopdemo.dao.*.*(..))")
    public void doForDAOPackage() {}

    @Pointcut("doForDAOPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

}
