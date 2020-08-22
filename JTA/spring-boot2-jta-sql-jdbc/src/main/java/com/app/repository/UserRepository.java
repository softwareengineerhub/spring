package com.app.repository;

import com.app.model.User;
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
public class UserRepository {

    @Autowired
    private DataSource dataSource;

    public void saveUser(String firstName){
        try(Connection c = dataSource.getConnection()){
            PreparedStatement ps = c.prepareStatement("INSERT INTO user(firstname) VALUES(?)");
            ps.setObject(1, firstName);
            ps.execute();
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
