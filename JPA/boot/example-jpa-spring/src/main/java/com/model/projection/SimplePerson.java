/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.projection;

import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author asusadmin
 */
public interface SimplePerson {
    
    @Value("#{target.id+1000}+1000")
    String getName();
    
    int getAge();
    
}
