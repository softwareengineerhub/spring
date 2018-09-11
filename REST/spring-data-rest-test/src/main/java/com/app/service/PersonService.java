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
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public int count() {
        return personRepository.count();
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void saveAll(List<Person> persons) {
        personRepository.saveAll(persons);
    }

    public Person get(int id) {
        return personRepository.get(id);
    }

    public List<Person> getAll() {
        return personRepository.getAll();
    }

    public void update(int id, Person person) {
        personRepository.update(id, person);
    }

    public void delete(int id) {
        personRepository.delete(id);
    }

    public void deleteAll() {
        personRepository.deleteAll();
    }

    public void makeAction() {
        System.out.println("makeAction()");
    }

}
