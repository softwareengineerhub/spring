/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository;

import com.app.dao.PersonRepository;
import com.app.model.Person;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface PersonCRUDRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.name=:name")
    List<Person> findByName(@Param("name") String name);

    @Modifying
    @Query("Update Person p Set p.name=:name, p.age=:age where id=:id")
    void updateById(@Param("id") long id, @Param("name") String name, @Param("age") int age);

}
