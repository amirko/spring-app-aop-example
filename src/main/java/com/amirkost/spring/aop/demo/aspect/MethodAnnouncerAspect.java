package com.amirkost.spring.aop.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Amir Kost on 28/09/2015.
 */
@Component
@Aspect
@Order(1)
public class MethodAnnouncerAspect {

    @Before("execution(* com.amirkost.spring.aop.demo.beans.*.*())")
    public void announceMethod(JoinPoint joinPoint) {
        System.out.println(Thread.currentThread().getName() + " Calling method: " + joinPoint.getSignature().getName());
    }
}
