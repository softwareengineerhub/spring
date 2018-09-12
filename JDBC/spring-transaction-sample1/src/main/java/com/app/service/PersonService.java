/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.dao.LogDAO;
import com.app.dao.PersonDAO;
import com.app.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service(value = "personService")
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class PersonService implements MyService {

    @Autowired
    private PersonDAO personDao;

    @Override
    public void makeAction() {
        int count = personDao.count();
        System.out.println("count=" + count);
        System.out.println("--------------------------");
        List<Person> persons = personDao.getAll();
        for (Person p : persons) {
            System.out.println(p);
        }
        System.out.println("--------------------------");
        System.out.println("--------------------------");      
        Person p = new Person();
        p.setAge(1);
        p.setName("Name1");
        personDao.save(p);
        System.out.println("count=" + personDao.count());
        Person candidat = new Person();
        candidat.setAge(11);
        candidat.setName("Name1-Update");
        personDao.update("Name1", candidat);
    }
}
