/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao.impl;

import com.app.dao.LogDAO;
import com.app.model.Log;
import com.app.model.Person;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Repository
@Transactional
public class LogDAOImpl implements LogDAO {

    @Autowired
    @Qualifier(value="logTemplate")
    private JdbcTemplate template;

    @Override
    public void save(Log log) {
        template.execute("INSERT INTO log(line) VALUES(?)", new PreparedStatementCallback<Object>() {

            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, log.getLine());
                ps.execute();
                return null;
            }

        });
    }

    @Override
    public int count() {
        return template.queryForObject("SELECT COUNT(*) FROM LOG", Integer.class);
    }

    @Override
    public List<Log> getAll() {
        return template.query("SELECT * FROM log", new RowMapper<Log>() {
            @Override
            public Log mapRow(ResultSet rs, int i) throws SQLException {
                Log log = new Log();
                log.setLine(rs.getString("line"));
                return log;
            }
        });
    }

    @Override
    public void update(String line, Log candidat) {
        template.update("UPDATE log SET line=? WHERE line=?", new PreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, candidat.getLine());
                ps.setString(2, line);
            }
        });
    }

}
