/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch03.beanvalidationjsr349;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class MyValidationService {

    private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

    public Set<ConstraintViolation<Dog>> validate(Dog dog) {
        Validator validator = factory.getValidator();
        return validator.validate(dog);
    }

}
