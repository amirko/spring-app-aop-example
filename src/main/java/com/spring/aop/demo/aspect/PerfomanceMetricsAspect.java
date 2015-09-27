package com.spring.aop.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by akost on 15/09/2015.
 */
@Component
@Aspect
public class PerfomanceMetricsAspect {


    @Around("execution(* com.spring.aop.demo.beans.*.*(..))")
    public void measurePerfomance(ProceedingJoinPoint joinPoint) {
        long t0 = System.currentTimeMillis();
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long t1 = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(Thread.currentThread().getName() + " method: " + methodName + " took " + (t1 - t0)  + " milliseconds");
    }
}
