/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch04.customvalidator;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class MySingerValidationService {
    
    @Autowired
    private Validator validator;
    
    public Set<ConstraintViolation<MySinger>> validateMySinger(MySinger mySinger){
        return validator.validate(mySinger);
    }
    
}
