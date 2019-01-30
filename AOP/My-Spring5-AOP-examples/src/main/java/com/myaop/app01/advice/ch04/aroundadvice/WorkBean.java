/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app01.advice.ch04.aroundadvice;

/**
 *
 * @author Denys.Prokopiuk
 */
public class WorkBean {

    public void doSomeWork(int numberOfTimes) {
        System.out.println("START doSomeWork()");
        for (int i = 0; i < numberOfTimes; i++) {
            work();
        }
        System.out.println("END doSomeWork()");
    }

    public void work() {
        System.out.println("work()");
    }
}
