/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository;

import com.app.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asusadmin
 */
@Repository
public class PersonRepository {
    
    private List<Person> list = new ArrayList();
    
    @PostConstruct
    public void init(){
        list.add(new Person("Name0", 0));
        list.add(new Person("Name1", 1));
        list.add(new Person("Name2", 2));
    }

    public List<Person> getList() {
        return list;
    }
    
}
