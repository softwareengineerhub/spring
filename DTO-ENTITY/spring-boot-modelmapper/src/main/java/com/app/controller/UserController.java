package com.app.controller;

import com.app.dto.UserDTO;
import com.app.entity.User;
import com.app.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private ModelMapper modelMapper = new ModelMapper();
    @Autowired
    private UserService userService;

    @PostMapping
    public void create(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        User user = modelMapper.map(userDTO, User.class);
        userService.create(user);
    }

    @GetMapping("/{id}")
    public UserDTO read(@PathVariable int id) {
        User user = userService.read(id);
        return modelMapper.map(user, UserDTO.class);
    }

    @GetMapping
    public List<UserDTO> readAll() {
        List<User> users = userService.readAll();
        List<UserDTO> res = new ArrayList();
        for(User user: users){
            res.add(modelMapper.map(user, UserDTO.class));
        }
        return res;
    }

    @PutMapping
    public void update(UserDTO candidate) {
        System.out.println(candidate);
        User user = modelMapper.map(candidate, User.class);
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    @DeleteMapping
    public void deleteAll() {
        userService.deleteAll();
    }

}
