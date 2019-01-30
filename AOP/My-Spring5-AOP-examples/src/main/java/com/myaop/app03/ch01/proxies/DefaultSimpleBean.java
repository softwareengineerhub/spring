/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myaop.app03.ch01.proxies;

/**
 *
 * @author Denys.Prokopiuk
 */
public class DefaultSimpleBean implements SimpleBean {
    private long dummy;

    @Override
    public void advised() {
        dummy = System.currentTimeMillis();
    }

    @Override
    public void unadvised() {
        dummy = System.currentTimeMillis();
    }
    
}
