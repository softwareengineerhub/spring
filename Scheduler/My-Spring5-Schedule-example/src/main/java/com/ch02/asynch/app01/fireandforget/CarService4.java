/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch02.asynch.app01.fireandforget;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class CarService4 {

    @Async
    public void doAction() {
        try {
            System.out.println("@Start doAction()");
            Thread.sleep(7000);
            System.out.println("@Finish doAction()");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void doProcess() {
        System.out.println("doProcess()");
    }

}
