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
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 *
 * @author asusadmin
 */
@Repository
public class DaoImpl implements Dao {
    
    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Person person) {
        PreparedStatementCallback pscb = new PreparedStatementCallback() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setObject(1, person.getName());
                ps.setObject(2, person.getAge());
                ps.execute();
                return "";
            }
        };
        jdbcTemplate.execute("INSERT INTO person(name, age) values(?,?)", pscb);
    }

    @Override
    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM PERSON", new RowMapper<Person>(){
            
            @Override
            public Person mapRow(ResultSet rs, int i) throws SQLException {
               String name = rs.getString("name");
               int age = rs.getInt("age");
               Person p = new Person();
               p.setName(name);
               p.setAge(age);
               return p;
            }
            
        });
        
    }

    @Override
    public Person findById(int id) {
          String sql = "SELECT * FROM PERSON where id=?";
          return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Person>(){
              @Override
              public Person mapRow(ResultSet rs, int i) throws SQLException {
                  String name = rs.getString("name");
                int age = rs.getInt("age");
                Person p = new Person();
                p.setName(name);
                p.setAge(age);
                return p;
              }
              
          });

    }

    @Override
    public void update(Person person, int id) {
        jdbcTemplate.update("UPDATE person set name=?,age=? where id=?",person.getName(), person.getAge(), id );
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.execute("delete from person");
    }

    @Override
    public void delete(int id) {
        jdbcTemplate.execute("delete from person where id=?", new PreparedStatementCallback() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setObject(1, id);
                ps.execute();
                return null;
            }
        });
    }
    
}
