/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import com.app.helper.HelperObject;
import com.app.helper.MyHelper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author asusadmin
 */
@Configuration
public class MyConfig {
    
    @ConditionalOnMissingBean
    @Bean
    public MyHelper myHelper2(){
        return new MyHelper() {
            @Override
            public String getMessage() {
                return "HELPER2";
            }
        };
    }
    
    @ConditionalOnMissingBean
    @Bean
    public MyHelper myHelper1(){
        return new MyHelper() {
            @Override
            public String getMessage() {
                return "HELPER1";
            }
        };
    }
    
    @Bean
    public HelperObject myHelper(MyHelper myHelper){
        return new HelperObject(myHelper);
    }
    
    
    
}
