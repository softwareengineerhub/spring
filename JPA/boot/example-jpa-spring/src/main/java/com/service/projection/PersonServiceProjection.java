/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.projection;

import com.model.projection.SimplePerson;
import com.repository.projection.PersonRepositoryProjection;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author asusadmin
 */
@Service
@Transactional
public class PersonServiceProjection {
    
    @Autowired
    private PersonRepositoryProjection personRepository;
    
    public List<SimplePerson> findSimpleByFirstName(String name){
        return personRepository.findSimplyByName(name);
    }
    
}
