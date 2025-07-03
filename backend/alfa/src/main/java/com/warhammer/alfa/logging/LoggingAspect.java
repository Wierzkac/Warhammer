package com.warhammer.alfa.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // Pointcut for all public methods in classes ending with 'Service' or 'Controller'
    @Pointcut("execution(public * *..*Service.*(..)) || execution(public * *..*Controller.*(..))")
    public void serviceOrControllerMethods() {}

    @Around("serviceOrControllerMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();

        logger.info("Entering: {}.{}({})", className, methodName, Arrays.toString(args));
        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();
            long duration = System.currentTimeMillis() - start;
            logger.info("Exiting: {}.{}(...) with result = {} (Execution time: {} ms)", className, methodName, result, duration);
            return result;
        } catch (Throwable ex) {
            long duration = System.currentTimeMillis() - start;
            logger.error("Exception in: {}.{}(...) with cause = {} (Execution time: {} ms)", className, methodName, ex.getMessage(), duration, ex);
            throw ex;
        }
    }
} 