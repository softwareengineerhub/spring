/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.smaple.ch01.hello;

import java.util.HashMap;
import java.util.Map;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denis
 */
@Configuration
@ComponentScan(basePackages = {"com.app01"})
public class MyConfiguration {

    @Bean
    public AppStatistics getAppStatistics() {
        return new AppStatisticsImpl();
    }
    
    @Bean
    public Person getPerson(){
        return new Person();
    }

    @Bean
    public MBeanExporter getJmxExporter() {
        MBeanExporter mbe = new MBeanExporter();
        Map<String, Object> map = new HashMap();
        map.put("bean:name=MyJmxAppStatistics", getAppStatistics());
        map.put("bean:name=Person", getPerson());
        mbe.setBeans(map);
        return mbe;
    }

}
