/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app01.advice.ch02.beforeadvice;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Guitarist implements Singer {

    private String lyrics = "You are gonna live forever in me";

    @Override
    public void sing() {
        System.out.println(lyrics);
    }

    public void speak(String word) {
        System.out.println("I say " + word);
    }

}
