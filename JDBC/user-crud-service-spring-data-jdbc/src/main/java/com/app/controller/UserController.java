package com.app.controller;

import com.app.dao.UserRepository;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@Transactional
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping(path = "/user")
    public List<User> findPersonsByNameAndAge(@RequestParam(name = "name") String name,
                                              @RequestParam(name = "age", required = false) int age) {
        return userRepository.findAllByNameAndAge(name, age);
    }

    @PostMapping(path = "/user")
    public void save(@RequestParam(name = "name") String name,
                     @RequestParam(name = "age") int age) {
        userRepository.save(new User(name, age));
    }

    @PutMapping(path = "/user")
    public void updateByAge(@RequestBody User user,
                            @RequestParam(name = "age") int age) {
        userRepository.updateUserByAge(user.getName(), user.getAge(), age);
    }

    @DeleteMapping(path = "/user/{name}/{age}")
    public void deleteByNameAndAge(@PathVariable(name = "name") String name,
                                   @PathVariable(name = "age") int age) {
        userRepository.deleteUserByNameAndAge(name, age);
    }

    @GetMapping(path = "/test")
    public void test() {
        User user = new User();
        user.setAge(1);
        user.setName("TestUsr1");
        User user1 = userRepository.save(user);
        System.out.println("----------After user1.save----------------user1="+user1);

        User user2 = new User();
        user2.setName("TestUsr1");
        user2.setAge(2);
        User user3 = new User();
        user3.setName("Update"+user1.getName());
        user3.setAge(user1.getAge());
        user3.setId(user1.getId());

        List<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user3);
        userRepository.saveAll(users);
    }

}
