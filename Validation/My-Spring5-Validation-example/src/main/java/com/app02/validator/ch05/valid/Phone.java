/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch05.valid;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Phone {

    @NotNull
    private String name;
    private int prize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

}
