/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch02.asynch.app02.future;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configuration
@ComponentScan(basePackages = "com.ch02.asynch.app02.future")
@EnableScheduling
@EnableAsync
public class AppConfig5 {
    
    
    
}
