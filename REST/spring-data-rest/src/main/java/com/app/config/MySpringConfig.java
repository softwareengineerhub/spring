/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configurable
@EnableWebMvc
@ComponentScan(value = {"com.app"})
public class MySpringConfig {
    
   // public 
    
}
