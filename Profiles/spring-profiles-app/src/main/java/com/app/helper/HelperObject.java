/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.helper;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 *
 * @author asusadmin
 */
@Component
@Profile("dev")
public class HelperObject {
    
    private MyHelper myHelper;

    public HelperObject(MyHelper myHelper) {
        this.myHelper = myHelper;
    }
    
    public String getMessage(){
        return myHelper.getMessage();
    }
    
}
