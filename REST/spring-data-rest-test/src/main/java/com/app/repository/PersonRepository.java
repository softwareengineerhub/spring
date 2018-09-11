/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository;

import com.app.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Denys.Prokopiuk
 */
@Repository
public class PersonRepository {

    private List<Person> persons;

    @PostConstruct
    public void init() {
        persons = new ArrayList<>();
    }

    public int count() {
        return persons.size();
    }

    public void save(Person person) {
        persons.add(person);
    }

    public void saveAll(List<Person> persons) {
        this.persons.addAll(persons);
    }

    public Person get(int id) {
        return persons.get(id);
    }

    public List<Person> getAll() {
        return persons;
    }

    public void update(int id, Person person) {
        persons.set(id, person);
    }

    public void delete(int id) {
        persons.remove(id);
    }

    public void deleteAll() {
        persons.clear();
    }

}
