/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.app.myconfig;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyServiceImpl implements MyService {

    private MyRepository myRepository;

    public MyServiceImpl(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    @Override
    public void persist(MyPerson myPerson) {
        System.out.println("@Start Persist");
        myRepository.save(myPerson);
        System.out.println("@End Persist");
    }

    @Override
    public void delete(MyPerson myPerson) {
        System.out.println("@Start delete");
        myRepository.remove(myPerson);
        System.out.println("@End delete");
    }

    @Override
    public MyPerson update(MyPerson myPerson, int ageFilter, String nameFilter) {
        System.out.println("@Start update");
        MyPerson filter = new MyPerson();
        filter.setAge(ageFilter);
        filter.setName(nameFilter);
        MyPerson oldPerson = myRepository.update(myPerson, filter);
        System.out.println("@End uodate");
        return oldPerson;
    }

    @Override
    public List<MyPerson> findAll() {
        try {
            System.out.println("@Before findAll");
            return myRepository.readAll();
        } finally {
            System.out.println("@After findAll");
        }
    }

    @Override
    public MyPerson find(String name, int age) {
        try {
            System.out.println("@Before find");
            return myRepository.read(name, age);
        } finally {
            System.out.println("@After find");
        }
    }

    public void destroy() {
        System.out.println("destroy()");
    }

}
