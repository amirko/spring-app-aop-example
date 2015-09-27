package com.spring.aop.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DemoThread implements Runnable {

    @Autowired
    private LogicBean logicBean;

    public void sayHello() {
        System.out.println(Thread.currentThread().getName() +  " Hello world!");
    }

    @Override
    public void run() {
        while(true) {
            sayHello();
            logicBean.doSomeLogic();
//            logicBean.doSomeOtherLogic();
        }
    }
}
