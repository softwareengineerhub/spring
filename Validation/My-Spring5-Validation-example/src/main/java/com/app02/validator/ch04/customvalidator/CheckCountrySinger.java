/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch04.customvalidator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Denys.Prokopiuk
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = CountrySingerValidator.class)
@Documented
public @interface CheckCountrySinger {

    String message() default "Country Singer should have gender and last name defined";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
