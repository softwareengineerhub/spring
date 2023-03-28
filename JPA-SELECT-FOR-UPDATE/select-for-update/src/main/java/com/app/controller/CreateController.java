package com.app.controller;

import com.app.entity.User;
import com.app.repository.UserRepository;
import com.app.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create")
public class CreateController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping()
    public void get() {
        User user1 = new User();
        user1.setFirstName("u1");
        userRepository.save(user1);

        User user2 = new User();
        user2.setFirstName("u2");
        userRepository.save(user2);

        User user3 = new User();
        user3.setFirstName("u3");
        userRepository.save(user3);

        User user4 = new User();
        user4.setFirstName("u4");
        userRepository.save(user4);
    }

}
