/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.methodinjection;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Singer {

    private String lyric = "I played a quick game of chess with the salt and pepper shaker";

    public void sing() {
        System.out.println(lyric);
    }
}
