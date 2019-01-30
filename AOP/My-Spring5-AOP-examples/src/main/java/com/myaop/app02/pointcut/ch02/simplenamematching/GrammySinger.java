/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app02.pointcut.ch02.simplenamematching;

import com.myaop.app02.pointcut.ch01.staticmatcher.ISinger;

/**
 *
 * @author Denys.Prokopiuk
 */
public class GrammySinger implements ISinger {

    @Override
    public void sing() {
        System.out.println("sing: Gravity is working against me And gravity wants to bring me down");
    }

    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void rest() {
        System.out.println("zzz");
    }

    public void talk() {
        System.out.println("talk");
    }
}
