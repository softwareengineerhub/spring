/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service(value = "globalService")
@Transactional
public class GlobalService implements MyService {
    @Autowired
    @Qualifier(value = "personService")
    private MyService myService1;
    @Autowired
    @Qualifier(value = "logService")
    private MyService myService2;
    
    
    @Override
    public void makeAction() {
        myService1.makeAction();
        myService2.makeAction();
    }
    
}
