package com.amirkost.spring.aop.demo.beans;

import org.springframework.stereotype.Component;

/**
 * Created by User on 28/09/2015.
 */
@Component
public class DaoImpl implements Dao {

    @Override
    public Integer getNumOfRecords() {
        return 42;
    }
}
