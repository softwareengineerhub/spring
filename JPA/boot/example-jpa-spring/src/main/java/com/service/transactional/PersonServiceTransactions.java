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
public class PersonServiceTransactions {
    
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonServiceTransactions2 personServiceTransactions2;
    @Autowired
    private PersonServiceTransactions3 personServiceTransactions3;
    
    public void doSave(String name){
        personRepository.save(new Person(name, 0));
        personServiceTransactions2.doSave("tr2");
        personServiceTransactions3.doSave("tr3");
    }
    
    public void removeAll(){
        personRepository.deleteAll();
    }
    
    
}
