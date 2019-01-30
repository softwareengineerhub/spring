/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app01.smaple.ch01.hello;

/**
 *
 * @author Denis
 */
public interface PersonMBean {

    public void setAge(int age);

    public int getAge();

    public void setName(String name);

    public String getName();
    
    public String process();
}
