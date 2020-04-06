/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository;

import com.app.model.Customer;
import java.util.Date;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    //List<Customer> findByEmail(String email);

    //List<Customer> findByDate(Date date);

}
