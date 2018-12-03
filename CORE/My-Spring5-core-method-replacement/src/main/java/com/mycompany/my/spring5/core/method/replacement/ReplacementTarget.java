/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.method.replacement;

/**
 *
 * @author Denys.Prokopiuk
 */
public class ReplacementTarget {

    public String formatMessage(String msg) {
        return "A";
    }

    public String formatMessage(Object msg) {
        return "B";
    }

}
