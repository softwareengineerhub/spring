/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.helper.MyHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asusadmin
 */
@Service
public class SignupService {
    
    @Autowired
    private DataSource ds;
    @Autowired
    private MyHelper myHelper;
    
   // @PostConstruct
    public void init(){
        String user = "me";
        String pass = "10";
        String role = "USER";
        create(user, pass, role);
    }
    
    public void create(String username, String password, String role){
        try(Connection c = ds.getConnection()){
            String sql = "insert into user_role(username,password,role,active) values(?,?,?, ?)";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setObject(1, username);
            ps.setObject(2, myHelper.hash(password));
            ps.setObject(3, role);
            ps.setObject(4, 1);
            ps.execute();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    
    
    
    
    
}
