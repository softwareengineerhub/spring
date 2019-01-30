/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch05.valid;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class PhoneService {

    @Autowired
    private PhoneRepository repository;
    
    public void process(@Valid Phone phone) {
        System.out.println("process()");
        repository.save(phone);
    }
}
