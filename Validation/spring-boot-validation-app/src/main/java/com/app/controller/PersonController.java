package com.app.controller;

import com.app.domain.Person;
import com.app.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private MyRepository myRepository;

    @PostMapping("/person")
    public void create(@Valid @RequestBody Person person){
        myRepository.getList().add(person);
    }

    @GetMapping("/person")
    public List<Person> findAll(){
        return myRepository.getList();
    }
}
