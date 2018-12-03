/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.scopes;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configuration
public class MyConfig2 {
    
    @Bean(value = "eagle")
    public MyEagleBean getEagleBean(){
        return new MyEagleBean();
    }
    
    @Bean(value = "lazy")
    @Lazy
    public MyLazyBean getLazyBean(){
        return new MyLazyBean();
    }
    
}
