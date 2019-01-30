/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app02.pointcut.ch01.staticmatcher;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Singer2 implements ISinger {

    @Override
    public void sing() {
        System.out.println("Singer2");
    }
    
}
