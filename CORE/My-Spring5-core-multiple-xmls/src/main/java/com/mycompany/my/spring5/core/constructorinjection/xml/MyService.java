/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.core.constructorinjection.xml;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyService {

    private MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public void process() {
        System.out.println("@Start process");
        myRepository.makeAction();
        System.out.println("@End process");
    }

}
