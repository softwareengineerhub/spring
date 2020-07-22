/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository;

import com.app.model.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asusadmin
 */
@Repository
public class DaoImpl implements Dao {
    
    @Inject
    private DataSource dataSource;

    @Override
    public void create(Person person) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("INSERT INTO person(name, age) values(?,?)");
            ps.setObject(1, person.getName());
            ps.setObject(2, person.getAge());
            ps.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public List<Person> findAll() {
        try(Connection c = getConnection()){
           List<Person> list = new ArrayList(); 
           PreparedStatement ps = c.prepareStatement("SELECT * FROM PERSON");
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
               String name = rs.getString("name");
               int age = rs.getInt("age");
               Person p = new Person();
               p.setName(name);
               p.setAge(age);
               list.add(p);
           }
           return list;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Person findById(int id) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("SELECT * FROM PERSON WHERE ID=?");
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Person p = new Person();
                p.setAge(rs.getInt("age"));
                p.setName(rs.getString("name"));
                return p;
            }
            return null;
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(Person person, int id) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("UPDATE person set name=?,age=? where id=?");
            ps.setObject(1, person.getName());
            ps.setObject(2, person.getAge());
            ps.setObject(3, id);
            ps.execute();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void deleteAll() {
        try(Connection c = getConnection()){
            c.prepareStatement("delete from person where id=?").execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try(Connection c = getConnection()){
            PreparedStatement ps = c.prepareStatement("delete from person where id=?");
            ps.setObject(1, id);
            ps.execute();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    
}
