/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.schedule.app03.pool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configuration
@ComponentScan(basePackages = "com.ch01.schedule.app03.pool")
@EnableScheduling
public class AppConfig3 {

    @Bean
    TaskScheduler carScheduler() {
        ThreadPoolTaskScheduler carScheduler = new ThreadPoolTaskScheduler();
        carScheduler.setPoolSize(10);
        return carScheduler;
    }

}
