/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app01.advice.ch05.throwsadvice;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.aop.framework.ProxyFactory;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        ErrorBean errorBean = new ErrorBean();
        
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new MyThrowsAdvice());
        pf.setTarget(errorBean);
        
        ErrorBean proxy = (ErrorBean) pf.getProxy();
        try {
            proxy.errorProneMethod();
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
        
        try {
            proxy.otherErrorProneMethod();
        } catch (Exception ex) {
            
        }
    }
    
}
