/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.hibernate.repository.ch01.norelation;

import com.mycompany.my.spring5.hibernate.model.ch01.norelation.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 * 
 * @Transactional - must be here to start TRANSACTION
 * Without tr will nor be started
 * 
 */
@Service
@Transactional
public class SingerService1 {

    @Autowired
    private SingerDao1 singerDao1;

    public void processSingers(Singer a, Singer b, Singer c) {
        singerDao1.save(a);
        singerDao1.save(b);
        //Singer a2 = new Singer();        
        //a2.setFirstName("A-Update");
        //a2.setId(a.getId());
        //singerDao1.update(a2);
        singerDao1.save2(c);
    }
}
