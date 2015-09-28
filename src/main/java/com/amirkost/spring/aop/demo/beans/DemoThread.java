package com.amirkost.spring.aop.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoThread implements Runnable {

    @Autowired
    private LogicBean logicBean;

    public void sayHello() {
    }

    @Override
    public void run() {
        while(true) {
            sayHello();
            logicBean.doSomeLogic();
        }
    }
}
