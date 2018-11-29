/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.espl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component
public class Department {
    @Value("#{emp.globalName}")    
    private String title;

    @Override
    public String toString() {
        return "Department{" + "title=" + title + '}';
    }
    
    
}
