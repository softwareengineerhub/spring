/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import com.app.model.Person;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface PersonRepository {

    public int size();

    public Person get(int id);

    public List<Person> getAll();

    public void create(Person person);

    public void createAll(List<Person> persons);

    public void update(int id, Person candidat);

    public void remove(int id);

    public void removeAll();

}
