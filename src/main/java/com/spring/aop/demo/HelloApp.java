package com.spring.aop.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.task.TaskExecutor;

public class HelloApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Runnable demoThread1 = context.getBean(Runnable.class);
        Runnable demoThread2 = context.getBean(Runnable.class);
        TaskExecutor taskExecutor = (TaskExecutor) context.getBean("taskExecutor");
        taskExecutor.execute(demoThread1);
        System.out.println("exectue2!");
        taskExecutor.execute(demoThread2);
    }
}
