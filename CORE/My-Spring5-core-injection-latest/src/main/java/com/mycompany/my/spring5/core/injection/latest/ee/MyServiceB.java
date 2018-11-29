/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.injection.latest.ee;

import com.mycompany.my.spring5.core.injection.latest.MyProcessor;
import com.mycompany.my.spring5.core.injection.latest.MyService;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Denys.Prokopiuk
 */
@Named
public class MyServiceB implements MyService {
    
    
    @Inject
    @Named(value = "myProcessorB")
    private MyProcessor myProcessor;
    
    
    @Override
    public void doAction() {
        System.out.println("Start MyServiceB");
        myProcessor.doProcess();
        System.out.println("End MyServiceB");
    }
    
}
