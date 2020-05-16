package ru.nik66.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import ru.nik66.aopdemo.entity.Account;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private static final Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    @Around("execution(* ru.nik66.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().toShortString();
        logger.info("===> Executing @Around advice on " + method);
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning(e.getMessage());
            if (e instanceof RuntimeException) {
                throw e;
            }
            result = "Major Accident! But no worries, your private AOP helicopter is on the way!";
        }
        long end = System.currentTimeMillis();
        logger.info("======> Duration: " + ((end - begin) / 1000.) + " seconds.");
        return result;
    }

    @Before("ru.nik66.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("===> Executing @Before advice on addAccount()");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        logger.info("Method: " + methodSignature);
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        for (Object arg : args) {
            logger.info(arg.toString());
            if (arg instanceof Account) {
                Account account = (Account) arg;
                logger.info("Account name: " + account.getName());
                logger.info("Account level: " + account.getLevel());
            }
        }
    }

    @After("execution(* ru.nik66.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> Executing @After advice on " + method);
    }

    @AfterReturning(pointcut = "execution(* ru.nik66.aopdemo.dao.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> Executing @AfterReturning advice on " + method);
        logger.info("===> result is: " + result);
        concertAccountNamesToUpperCase(result);
    }

    @AfterThrowing(pointcut = "execution(* ru.nik66.aopdemo.dao.AccountDAO.findAccounts(..))", throwing = "e")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable e) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("===> Executing @AfterThrowing advice on " + method);
        logger.info("===> the exception is: " + e);
    }

    private void concertAccountNamesToUpperCase(List<Account> accounts) {
        for (Account account : accounts) {
            account.setName(account.getName().toUpperCase());
            account.setLevel(account.getLevel().toUpperCase());
        }
    }

}
