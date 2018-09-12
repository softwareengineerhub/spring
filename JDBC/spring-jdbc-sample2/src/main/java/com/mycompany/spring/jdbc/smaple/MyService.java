/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.jdbc.smaple;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class MyService {

    @Autowired
    private DAO dao;

    public void makeAction() {
        int count = dao.count();
        System.out.println("count=" + count);
        System.out.println("--------------------------");
        List<Person> persons = dao.getAll();
        for (Person p : persons) {
            System.out.println(p);
        }
        System.out.println("--------------------------");
        System.out.println("--------------------------");
        persons = dao.getAll2();
        for (Person p : persons) {
            System.out.println(p);
        }
        System.out.println("--------------------------");
        Person p = new Person();
        p.setAge(1);
        p.setName("Name1");
        dao.save(p);
        System.out.println("count=" + dao.count());
        Person candidat = new Person();
        candidat.setAge(11);
        candidat.setName("Name1-Update");
        dao.update("Name1", candidat);
    }
}
