package com.example.L10AOPdemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {


    private static Logger LOGGER = LoggerFactory.getLogger(SimpleAspect.class);


    @Before("execution(* com.example.L10AOPdemo.service.AOPService.getHelloMsg(..))")
    public void beforeMethod(){
        LOGGER.info("Executing before method");
    }

    @After("execution(* com.example.L10AOPdemo.service.AOPService.getHelloMsg(..))")
    public void afterMethod(){
        LOGGER.info("Executing after method");
    }

    @Around("@annotation(com.example.L10AOPdemo.aspect.LogExecutionTime)")
    public Object logExecutionTimeOfMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();
        LOGGER.info("Execution Time : {} ms",end - start);
        return result;
    }

}
