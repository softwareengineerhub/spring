/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.autowired.priority;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyProcessorB implements MyProcessor {

    @Override
    public void doProcess() {
        System.out.println("MyProcessorA.doProcess()");
    }

}
