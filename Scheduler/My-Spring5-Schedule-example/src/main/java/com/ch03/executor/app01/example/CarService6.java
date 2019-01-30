/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch03.executor.app01.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class CarService6 {

    @Autowired
    private TaskExecutor taskExecutor;
    
    public void executeTask(){
        for(int i=0;i<10;i++){
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("this is Thread # "+Thread.currentThread());
                }
            });
        }
    }
}
