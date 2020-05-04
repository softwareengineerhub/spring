/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.boot.app01;

import java.util.concurrent.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Denys.Prokopiuk
 */
@RestController
public class MyController {
    @Autowired
    private AsyncTaskExecutor taskExecutor;

    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person get() {
        //taskExecutor.submit(clbl);
        Person person = new Person();
        person.setAge(10);
        person.setName("Name10"+taskExecutor);
        return person;
    }

}
