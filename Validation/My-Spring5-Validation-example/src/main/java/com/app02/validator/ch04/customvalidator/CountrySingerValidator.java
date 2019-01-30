/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch04.customvalidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class CountrySingerValidator implements ConstraintValidator<CheckCountrySinger, MySinger> {

    @Override
    public void initialize(CheckCountrySinger constraintAnnotation) {

    }

    @Override
    public boolean isValid(MySinger mySinger, ConstraintValidatorContext context) {
        if (mySinger.getLastName() == null) {
            return false;
        }
        if(mySinger.getFirstName()==null){
            return false;
        }
        return true;
    }

}
