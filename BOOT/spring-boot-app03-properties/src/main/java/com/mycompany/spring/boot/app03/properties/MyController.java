/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.boot.app03.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Denys.Prokopiuk
 */
@RestController
public class MyController {
    
    @Autowired
    private SimpleDataProperties simpleDataProperties;
    @Autowired
    private SimpleConfigurationProperties configurationProperties;
    @Autowired
    private AppProperties appProperties;
    
    
    @RequestMapping(value="/simple", method = GET)
    public SimpleDataProperties getSimpleDataProperties(){
        return simpleDataProperties;
    }
    
    @RequestMapping(value="/app", method = GET)
    public AppProperties getAppProperties(){
        return appProperties;
    }
    
    @RequestMapping(value="/configuration", method = GET)
    public SimpleConfigurationProperties getConfigurationProperties(){
        return configurationProperties;
    }
    
}
