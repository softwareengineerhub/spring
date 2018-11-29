/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.setterinjection.annotation;

import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component(value="myRepository")
public class MyRepository {

    public void makeAction() {
        System.out.println("Repository action");
    }

}
