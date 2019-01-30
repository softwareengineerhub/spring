/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app02.validator.ch05.valid;

import javax.validation.Valid;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Denys.Prokopiuk
 */
@Repository
public class PhoneRepository {

    public void save(@Valid Phone phone) {
        System.out.println("\tsave()");
    }

}
