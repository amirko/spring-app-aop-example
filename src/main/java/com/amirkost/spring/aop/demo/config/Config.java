package com.amirkost.spring.aop.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Amir Kost on 12/09/2015.
 */
@Configuration
@EnableAspectJAutoProxy
public class Config {

    @Bean(name = "taskExecutor")
    public TaskExecutor getTaskExecutor() {
        final ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setThreadFactory(new ThreadFactory() {
            private AtomicInteger curr = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("DemoThread_" + curr.getAndIncrement());
                return t;
            }
        });
        threadPoolTaskExecutor.setCorePoolSize(2);
        return threadPoolTaskExecutor;
    }

}
