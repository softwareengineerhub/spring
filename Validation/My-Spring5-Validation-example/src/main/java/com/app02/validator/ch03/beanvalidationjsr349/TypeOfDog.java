/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch03.beanvalidationjsr349;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Denys.Prokopiuk
 */
public class TypeOfDog {
    @NotNull
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
}
