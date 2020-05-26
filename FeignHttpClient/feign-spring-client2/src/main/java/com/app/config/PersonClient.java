/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.config;

import com.app.model.Person;
import feign.Headers;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 *
 * @author asusadmin
 */
//@FeignClient(name="PersonClient", url= "http://127.0.0.1:8080/")
public interface PersonClient {

    @PostMapping(value = "/persons")
    @Headers("Content-Type: application/json")
    public Response add(Person person);

    @GetMapping("/persons/{id}")
    public Person findById(@PathVariable int id);

    @GetMapping("/persons/{id}")
    public Person findById2(@PathVariable("id") int id);

    @GetMapping("/persons")
    public List<Person> findAll();

}
