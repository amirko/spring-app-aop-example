package com.spring.aop.demo.beans;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by akost on 15/09/2015.
 */

@Component
public class LogicBean {

    private static final long MIN_SLEEP = 100;
    private static final long MAX_SLEEP = 1000;

    private Random rnd = new Random(System.currentTimeMillis());

    public void doSomeLogic() {
        try {
            Thread.currentThread().sleep(MIN_SLEEP + rnd.nextInt((int) (MAX_SLEEP - MIN_SLEEP)));
            doNothing();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void doNothing() {

    }
}

