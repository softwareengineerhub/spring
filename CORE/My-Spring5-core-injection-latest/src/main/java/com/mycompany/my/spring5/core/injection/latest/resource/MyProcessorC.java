/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.injection.latest.resource;

import com.mycompany.my.spring5.core.injection.latest.MyProcessor;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component
public class MyProcessorC implements MyProcessor {

    @Override
    public void doProcess() {
        System.out.println("MyProcessorC.doProcess()");
    }
    
}
