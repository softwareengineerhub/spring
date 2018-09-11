/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.model.Person;
import com.app.dao.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.app.repository.PersonCRUDRepository;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service(value = "service")
public class PersonServiceImpl implements PersonService {

    @Autowired
    //@Qualifier(value = "default")
    @Qualifier(value = "jpaDefault")
    private PersonRepository personRepository;
    
    @Autowired
    PersonCRUDRepository customerRepository;

    @Override
    public long count() {
        return personRepository.size();
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
        personRepository.create(person);
    }

    @Override
    public void saveAll(List<Person> persons) {
        personRepository.createAll(persons);
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
