package com.app.controller;

import com.app.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PersonControllerTest {

    @Autowired
    private PersonService personService;
    private String username = "test2";
    private String password = "1";


    @Test
    public void workflowTest(){
        assertEquals("SUCCESS", info());
        List<Person> personList = findAll();
        assertEquals(personList.size(), 3);
        int n = personList.size();

        Person person = new Person();
        person.setName("test1");
        person.setAge(11);
        create(person);
        personList = findAll();
        assertEquals(personList.size(), n+1);

        Person p2 = finaById(3);
        assertEquals(p2, person);

        List<Person> testPersons = new ArrayList<>();
        for(int i=0;i<3;i++) {
            Person p = new Person();
            p.setName("P"+i);
            p.setAge(i);
            testPersons.add(p);
        }
        testPersons.add(person);

        personList = findAll();
        assertEquals(personList, testPersons);


    }

    private void create(Person person){
        personService.create(person, username, password);
    }

    private String info(){
        return personService.info();
    }

    private List<Person> findAll(){
        return personService.readAll(username, password);
    }

    private Person finaById(int id){
        return personService.readById(id, username, password);
    }




}
