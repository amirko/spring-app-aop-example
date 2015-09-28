package com.amirkost.spring.aop.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by Amir Kost on 15/09/2015.
 */

@Component
@Scope("prototype")
public class LogicBeanImpl implements LogicBean {

    private static final long MIN_SLEEP = 100;
    private static final long MAX_SLEEP = 1000;

    private Random rnd = new Random(System.currentTimeMillis());

    @Autowired
    private Dao dao;

    @Override
    public void doSomeLogic() {
        try {
            Thread.currentThread().sleep(MIN_SLEEP + rnd.nextInt((int) (MAX_SLEEP - MIN_SLEEP)));
            doNothing();
            dao.getNumOfRecords();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doNothing() {

    }
}

