/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao.impl;

import com.app.model.Person;
import com.app.dao.PersonDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Repository
@Transactional
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    @Qualifier(value="personTemplate")
    private JdbcTemplate template;

    @Override
    public void save(Person person) {
        template.execute("INSERT INTO person(name, age) VALUES(?,?)", new PreparedStatementCallback<Object>() {
         
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, person.getName());
                ps.setInt(2, person.getAge());
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
        return template.query("SELECT * FROM person", new RowMapper<Person>() {

            @Override
            public Person mapRow(ResultSet rs, int i) throws SQLException {
                Person p = new Person();
                p.setName(rs.getString("name"));
                p.setAge(rs.getInt("age"));
                return p;
            }
        });
    }

    @Override
    public void update(String name, Person candidat) {
        template.update("UPDATE person SET name=?, age=? WHERE name=?", candidat.getName(), candidat.getAge(), name);
    }

}
