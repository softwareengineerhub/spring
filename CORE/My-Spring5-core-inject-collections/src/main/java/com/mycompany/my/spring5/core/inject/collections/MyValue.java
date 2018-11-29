/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.inject.collections;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyValue {

    private String occupation;

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    @Override
    public String toString() {
        return "MyValue{" + "occupation=" + occupation + '}';
    }
    
    

}
