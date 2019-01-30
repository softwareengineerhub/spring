/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch02.beanvalidationjsr349;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Gender {

    @NotNull
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
