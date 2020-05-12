/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.helper;

/**
 *
 * @author asusadmin
 */
public class HelperObject {
    
    private MyHelper myHelper;

    public HelperObject(MyHelper myHelper) {
        this.myHelper = myHelper;
    }
    
    public String getMessage(){
        return myHelper.getMessage();
    }
    
}
