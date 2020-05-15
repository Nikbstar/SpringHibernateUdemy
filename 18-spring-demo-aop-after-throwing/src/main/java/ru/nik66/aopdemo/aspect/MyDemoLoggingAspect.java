package ru.nik66.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.nik66.aopdemo.entity.Account;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Before("ru.nik66.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("===> Executing @Before advice on addAccount()");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + methodSignature);
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        for (Object arg : args) {
            System.out.println(arg);
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* ru.nik66.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===> Executing @AfterReturning advice on " + method);
        System.out.println("===> result is: " + result);
        concertAccountNamesToUpperCase(result);
    }

    @AfterThrowing(pointcut = "execution(* ru.nik66.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "e")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable e) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("===> Executing @AfterThrowing advice on " + method);
        System.out.println("===> the exception is: " + e);
    }

    private void concertAccountNamesToUpperCase(List<Account> accounts) {
        for (Account account : accounts) {
            account.setName(account.getName().toUpperCase());
            account.setLevel(account.getLevel().toUpperCase());
        }
    }

}
