/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.feign.client;

import com.app.model.Person;
import com.app.model.PersonResource;
import feign.Headers;
import feign.Param;
import feign.RequestLine;
import java.util.List;

/**
 *
 * @author asusadmin
 */
public interface PersonClient {

    @RequestLine("POST /persons")
    @Headers("Content-Type: application/json")
    public void add(Person person);

    @RequestLine("GET /persons/{id}")
    public PersonResource findById(@Param("id") int id);

    @RequestLine("GET /persons/{id}")
    public Person findById2(@Param("id") int id);

    @RequestLine("GET /persons")
    public List<Person> findAll();

}
