/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.autowired.priority.annotations;

import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component
public class EmployeeA extends Employee {

    @Override
    public void doAction() {
        System.out.println("EmployeeA.action()");
    }

}
