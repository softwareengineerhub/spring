/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repository.projection;

import com.model.Person;
import com.model.projection.SimplePerson;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author asusadmin
 */
public interface PersonRepositoryProjection extends JpaRepository<Person, Integer> {

    List<SimplePerson> findSimplyByName(String name);
    
}
