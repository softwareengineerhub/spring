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
@Component
public class MyEmployee {

    private String actionType = "Employee action";

    public void doAction() {
        System.out.println(actionType);
    }

}
