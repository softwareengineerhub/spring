package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;

@Service
public class SigmupService {
    @Autowired
    private DataSource ds;

    public void create(String username, String password, String role){
        try(Connection c = ds.getConnection()){
            String sql = "insert into user_role(username, password, role, active) values(?, ?, ?, ?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setObject(1, username);

            ps.setObject(2, BCrypt.hashpw(password, BCrypt.gensalt()));
            ps.setObject(3, role);
            ps.setObject(4, 1);
            ps.execute();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }




}
