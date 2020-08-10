package com.app;

import com.app.model.Person;
import com.app.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    public static void main(String[] args) {
        System.setProperty("server.port", "8081");
        SpringApplication.run(Main.class, args);
    }

    @Autowired
    private PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        /*Person p = new Person();
        p.setAge(20);
        p.setName("p20");
        personService.create(p, "test2", "1");
        System.exit(0);*/

        List<Person> persons =  personService.readAll("test2", "1");
        for(Person person: persons){
            System.out.println(person);
        }

        System.out.println("------------------------");
        Person person = personService.readById(2, "test2","1");
        System.out.println(person);

        System.out.println("------------------------");
        personService.info();
        System.exit(0);
    }
}
