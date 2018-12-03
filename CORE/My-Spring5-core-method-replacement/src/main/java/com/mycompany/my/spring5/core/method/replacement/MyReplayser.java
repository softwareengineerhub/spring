/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.method.replacement;

import java.lang.reflect.Method;
import org.springframework.beans.factory.support.MethodReplacer;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyReplayser implements MethodReplacer {

    @Override
    public Object reimplement(Object o, Method method, Object[] os) throws Throwable {
        if(isFormatMessageMethod(o, method, os)){
            return "Replacement";
        } else {
            System.out.println("\tDefault method");            
            return "test";//method.invoke(o, os);
        }
    }
    
    public boolean isFormatMessageMethod(Object o, Method method, Object[] os){
        String name=method.getName();
        Class type = method.getReturnType();
        if(type == Object.class){
            return true;
        }        
        return false;
    }
    
}
