package com.app.service;

import com.app.entity.User;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class MyUpdateService {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void process() {
        List<User> list = userRepository.findAllById(Arrays.asList(10, 11, 12, 13));
        System.out.println("\t###simple update:size=" + list.size());
        for (User user : list) {
            System.out.println("\t###" + user);
        }
        for (User u : list) {
            u.setPassword("\t###update" + new Date());
        }
        System.out.println("\t###simple update @Before save");
        userRepository.saveAll(list);
        System.out.println("\t###simple update @After save");
    }

}
