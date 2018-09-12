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
public interface PersonDAO {

    public void save(Person person);

    public int count();

    public List<Person> getAll();

    public void update(String name, Person candidat);
}
