/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.bean.names.annotations;

import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component(value = "emp2")
public class MyEmployee2 {
    
    private String actionType = "Employee action 2";

    public void doAction() {
        System.out.println(actionType);
    }
    
}
