/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.injection.latest.ee;

import com.mycompany.my.spring5.core.injection.latest.MyProcessor;
import javax.annotation.processing.Processor;
import javax.inject.Named;

/**
 *
 * @author Denys.Prokopiuk
 */
@Named(value = "myProcessorB")
public class MyProcessorB implements MyProcessor {

    @Override
    public void doProcess() {
        System.out.println("MyProcessorB.doProcess()");
    }
    
}
