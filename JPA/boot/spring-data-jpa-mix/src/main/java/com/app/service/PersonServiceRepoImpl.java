/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.model.Person;
import com.app.repository.PersonCRUDRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service(value = "personServiceRepo")
@Transactional
public class PersonServiceRepoImpl implements PersonService {

    @Autowired
    private PersonCRUDRepository repository;

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public Person get(int id) {
        long idValue = id;
        return repository.findOne(idValue);
    }

    @Override
    public List<Person> getAll() {
        return repository.findByName("test");
        //return (List<Person>) repository.findAll();
    }

    @Override
    public void save(Person person) {
        repository.save(person);
    }

    @Override
    public void saveAll(List<Person> persons) {
        repository.save(persons);
    }

    @Override
    public void update(int id, Person candidat) {
        repository.updateById(id, candidat.getName(), candidat.getAge());
    }

    @Override
    public void remove(int id) {
        long idValue = id;
        repository.delete(idValue);
    }

    @Override
    public void removeAll() {
        repository.deleteAll();
    }

}
