/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.jdbc.smaple;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Denys.Prokopiuk
 */
@Repository
public class DAOImpl implements DAO {

    @Autowired
    private JdbcTemplate template;
    @Autowired
    @Qualifier("b")
    private MyProcessor myProcessor;
    
    @PostConstruct
    public void init(){
        myProcessor.process();
    }

    @Override
    public void save(Person person) {
        template.execute("INSERT INTO person(age, name) VALUES(?,?)", new PreparedStatementCallback() {

            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1, person.getAge());
                ps.setString(2, person.getName());
                ps.execute();
                return null;
            }
        });

    }

    @Override
    public int count() {
        return template.execute("SELECT COUNT(*) FROM person", new PreparedStatementCallback<Integer>() {

            @Override
            public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ResultSet rs = ps.executeQuery();
                rs.next();
                return rs.getInt(1);
            }
        });
    }

    @Override
    public List<Person> getAll() {
        return template.execute("SELECT * FROM person", new PreparedStatementCallback<List<Person>>() {

            @Override
            public List<Person> doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                List<Person> persons = new ArrayList();
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Person p = new Person();
                    persons.add(p);
                    p.setAge(rs.getInt("age"));
                    p.setName(rs.getString("name"));
                }
                return persons;
            }
        });
    }

}
