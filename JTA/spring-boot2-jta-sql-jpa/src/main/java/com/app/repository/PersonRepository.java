package com.app.repository;

import com.app.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Transactional(Transactional.TxType.REQUIRES_NEW)
@Service
public class PersonRepository {

    @Autowired
    private EntityManager entityManager;

    public void savePerson(String name, int age){
        Person person = new Person();
        person.setAge(age);
        person.setName(name);
        entityManager.persist(person);
    }
}
