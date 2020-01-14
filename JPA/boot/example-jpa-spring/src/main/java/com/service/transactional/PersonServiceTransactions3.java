/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.transactional;

import com.model.Person;
import com.repository.PersonRepository;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asusadmin
 */
@Service
@Transactional
public class PersonServiceTransactions3 {
    
    @Autowired
    private PersonRepository personRepository;
    
    public void doSave(String name){
        throw new RuntimeException();
    }
    
    
}
