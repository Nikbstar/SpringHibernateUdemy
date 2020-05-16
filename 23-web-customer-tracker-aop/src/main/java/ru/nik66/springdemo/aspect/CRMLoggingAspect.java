package ru.nik66.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

    private static final Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("===> in @Before advice: calling method > " + methodName);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            logger.info("======> argument: " + arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        logger.info("===> in @AfterReturning advice: calling method > " + methodName);
        logger.info("======> result: " + result);
    }

    @Pointcut("execution(* ru.nik66.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* ru.nik66.springdemo.serivce.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* ru.nik66.springdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow() {}

}
