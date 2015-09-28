package com.amirkost.spring.aop.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;

public class DemoApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.amirkost.spring.aop.demo");
        Runnable demoThread1 = context.getBean(Runnable.class);
        Runnable demoThread2 = context.getBean(Runnable.class);
        TaskExecutor taskExecutor = (TaskExecutor) context.getBean("taskExecutor");
        System.out.println("Running!");
        taskExecutor.execute(demoThread1);
        taskExecutor.execute(demoThread2);
    }
}
