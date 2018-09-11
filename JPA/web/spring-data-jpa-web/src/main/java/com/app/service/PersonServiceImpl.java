/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.model.Person;
import com.app.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    @Qualifier(value = "default")
    private PersonRepository personRepository;

    @Override
    public int count() {
        return personRepository.count();
    }

    @Override
    public Person get(int id) {
        return personRepository.get(id);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.getAll();
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void saveAll(List<Person> persons) {
        personRepository.saveAll(persons);
    }

    @Override
    public void update(int id, Person candidat) {
        personRepository.update(id, candidat);
    }

    @Override
    public void remove(int id) {
        personRepository.remove(id);
    }

    @Override
    public void removeAll() {
        personRepository.removeAll();
    }

}
