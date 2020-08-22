package com.app.service;

import com.app.repository.PersonRepository;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.sql.SQLException;

@Service
@Transactional
public class MyService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private UserRepository userRepository;

    public void process(){
        personRepository.savePerson("p1",1);
        //userRepository.saveUser("u1");
        userRepository.saveUserIncorrect("u1");
    }


}

