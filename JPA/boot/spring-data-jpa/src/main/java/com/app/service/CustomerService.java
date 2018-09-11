/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.model.Customer;
import com.app.repository.CustomerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    //@Autowired
    //CrudRepository<Customer, Long> customerRepository;

    public long count() {
        return customerRepository.count();
    }

    public Customer get(long id) {
        return customerRepository.findOne(id);
    }

    public List<Customer> getAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void saveAll(List<Customer> customers) {
        customerRepository.save(customers);
    }

    public void update(long id, Customer candidat) {
        Customer current = customerRepository.findOne(id);
        current.setName(candidat.getName());
        current.setAge(candidat.getAge());
        customerRepository.save(current);
    }

    public void remove(long id) {
        customerRepository.delete(id);
    }

    public void removeAll() {
        customerRepository.deleteAll();
    }

}
