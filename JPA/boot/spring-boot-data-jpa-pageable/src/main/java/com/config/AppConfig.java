package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableScheduling
public class AppConfig {

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        ThreadPoolTaskScheduler threadPoolTaskScheduler
                = new ThreadPoolTaskScheduler();

        //threadPoolTaskScheduler.setPoolSize(5);
        //threadPoolTaskScheduler.setThreadNamePrefix(
        //        "ThreadPoolTaskScheduler");
        return threadPoolTaskScheduler;
    }

    @Bean
    public ThreadPoolTaskExecutor executor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //executor.setCorePoolSize(4);
        //executor.setMaxPoolSize(4);
        //executor.setThreadNamePrefix("default_task_executor_thread");
        //executor.initialize();
        return executor;

    }
}
