/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.helper;

import org.springframework.stereotype.Component;

/**
 *
 * @author asusadmin
 */
@Component
public class MySimpleHelper implements MyHelper {

    @Override
    public String getMessage() {
        return "SimpleMessage";
    }
    
}
