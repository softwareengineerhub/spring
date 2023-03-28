package com.app.service;

import com.app.entity.User;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MyService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void process(long delay, int id){
        List<User> list = userRepository.findForUpdate(id);
        System.out.println("size="+list.size());
        for(User user: list){
            System.out.println(user);
        }
        System.out.println("--------sleep start");
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--------sleep end");
        for(User u: list){
            u.setFirstName("test"+new Date());
        }
        userRepository.saveAll(list);
    }

}
