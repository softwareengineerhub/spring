/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch02.beanvalidationjsr349;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class SingerValidationService {
    
    @Autowired
    private Validator validator;
    
    public Set<ConstraintViolation<Employee>> validateSinger(Employee employee){
        return validator.validate(employee);
    }
}
