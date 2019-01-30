/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app04.ch02.aspectjannotations;

import com.myaop.app02.pointcut.ch02.simplenamematching.Guitar;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component
public class MyPersonCh02 {

    public void doAction() {

    }
    
    public void sing(Guitar value){
        System.out.println("MyPersonCh02.sing; value="+value);
    }

}
