/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.espl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configuration
@ComponentScan({"com.mycompany.my.spring5.core.espl"})
public class AppConfig {
    
    @Bean(value = "emp")
    public Employee getEmployee(){
        Employee emp = new Employee();
        emp.setGlobalName("Alpha");
        emp.setName("Jack");
        return emp;
    }
    
}
