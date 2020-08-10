package com.app.controller;

import com.app.model.Person;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
    private List<Person> persons = new ArrayList<>();

    @PostConstruct
    public void init(){
        for(int i=0;i<3;i++) {
            Person p = new Person();
            p.setName("P"+i);
            p.setAge(i);
            persons.add(p);
        }
    }

    @GetMapping("/info")
    public String info(){
        return "SUCCESS";
    }

    @PostMapping
    public void create(@RequestBody Person person){
        persons.add(person);
    }

    @GetMapping
    public List<Person> readAll(){
        return persons;
    }

    @GetMapping("/id/{id}")
    public Person readById(@PathVariable int id){
        return persons.get(id);
    }



}
