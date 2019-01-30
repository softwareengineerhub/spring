/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch01.springinterface;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Denys.Prokopiuk
 */
@Component
public class SingerValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Singer.class == type;
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstName.empty");
    }

}
