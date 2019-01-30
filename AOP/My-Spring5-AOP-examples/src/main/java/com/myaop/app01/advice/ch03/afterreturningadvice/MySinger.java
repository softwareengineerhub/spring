/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app01.advice.ch03.afterreturningadvice;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MySinger {

    public void sing() {
        System.out.println("My Singer");
    }

    public String speak(String msg) {
        System.out.println(msg);
        return "Test";
    }
}
