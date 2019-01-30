/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch02.asynch.app02.future;

import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class CarService5 {

    public Future<String> doAction() {
        try {
            System.out.println("Start doAction");
            Thread.sleep(7000);
            System.out.println("Finish doAction");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } finally {
            return new AsyncResult<String>("Completed");
        }
    }

    public void doProcess() {
        System.out.println("doProcess()");
    }

}
