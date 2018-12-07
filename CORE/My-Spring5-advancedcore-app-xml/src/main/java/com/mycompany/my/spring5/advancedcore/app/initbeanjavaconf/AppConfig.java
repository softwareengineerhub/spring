/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.advancedcore.app.initbeanjavaconf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 *
 * @author Denys.Prokopiuk
 */
@Configuration
public class AppConfig {

    @Bean(initMethod = "init")
    @Lazy
    public MyCar myCar() {
        MyCar myCar = new MyCar();
        myCar.setName("Car1");
        myCar.setYear(1);
        return myCar;
    }
}
