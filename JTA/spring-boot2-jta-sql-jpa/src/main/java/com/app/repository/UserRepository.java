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
    private EntityManager entityManager;

    public void saveUserIncorrect(String firstName){
        User user = new User();
        user.setFirstname(firstName);
        entityManager.persist(user);
        if(1<2){
            String s = null;
            s.toString();
        }
    }

    public void saveUser(String firstName){
        User user = new User();
        user.setFirstname(firstName);
        entityManager.persist(user);
    }
}
