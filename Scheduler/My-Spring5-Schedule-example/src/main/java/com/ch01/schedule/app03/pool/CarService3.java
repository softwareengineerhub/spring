/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.schedule.app03.pool;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class CarService3 {
    
    @Scheduled(cron = "0 * * * * *")
    public void doAction() {
        System.out.println("doAction()");
    }

    @Scheduled(cron = "10 * * * * *")
    public void doProcess() {
        System.out.println("doProcess()");
    }
}
