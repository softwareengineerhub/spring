/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.injection.latest.resource;

import com.mycompany.my.spring5.core.injection.latest.MyProcessor;
import com.mycompany.my.spring5.core.injection.latest.MyService;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component(value = "myServiceC2")
public class MyServiceC2 implements MyService {
    
    @Resource(name="c2")
    private MyProcessor processor;
    
    @Override
    public void doAction() {
        System.out.println("start MyServiceC2");
        processor.doProcess();
        System.out.println("end MyServiceC2");
    }
    
}
