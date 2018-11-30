/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.methodinjection;

/**
 *
 * @author Denys.Prokopiuk
 */
public abstract class AbtractLookupDemoBean implements DemoBean {

//    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }

}
