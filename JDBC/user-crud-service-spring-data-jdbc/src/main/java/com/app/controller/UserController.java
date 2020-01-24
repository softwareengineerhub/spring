package com.app.controller;

import com.app.dao.UserRepository;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

}
