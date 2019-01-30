/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch03.beanvalidationjsr349;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Denys.Prokopiuk
 */
//@Valid
public class Dog {

    @NotNull
    private String name;
    @Valid
   // @NotNull
    private TypeOfDog typeOfDog;

    public TypeOfDog getTypeOfDog() {
        return typeOfDog;
    }

    public void setTypeOfDog(TypeOfDog typeOfDog) {
        this.typeOfDog = typeOfDog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
