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
@Repository(value = "default")
public class DefaultPersonRepositoryImpl implements PersonRepository {

    private List<Person> persons;

    @PostConstruct
    public void init() {
        persons = new ArrayList<>();
    }

    @Override
    public int count() {
        return persons.size();
    }

    @Override
    public Person get(int id) {
        return persons.get(id);
    }

    @Override
    public List<Person> getAll() {
        return persons;
    }

    @Override
    public void save(Person person) {
        persons.add(person);
    }

    @Override
    public void saveAll(List<Person> persons) {
        this.persons.addAll(persons);
    }

    @Override
    public void update(int id, Person candidat) {
        persons.set(id, candidat);
    }

    @Override
    public void remove(int id) {
        persons.remove(id);
    }

    @Override
    public void removeAll() {
        persons.clear();
    }

}
