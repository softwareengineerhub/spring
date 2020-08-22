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

@Transactional
@Service
public class PersonRepository {

    @Autowired
    private DataSource dataSource;

    public void savePerson(String name, int age){
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement("INSERT INTO person(name, age) VALUES(?,?)");
            ps.setObject(1, name);
            ps.setObject(2, age);
            ps.execute();
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
