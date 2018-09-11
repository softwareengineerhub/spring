/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.model.Employee;
import com.app.repository.EmployeeReposiotry;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeReposiotry employeeReposiotry;
    
    public void add(Employee employee) {
        employeeReposiotry.add(employee);
    }
    
    public void addAll(List<Employee> employees) {
        employeeReposiotry.addAll(employees);
    }
    
    public Employee get(int id) {
        return employeeReposiotry.get(id);
    }
    
    public List<Employee> getAll() {
        return employeeReposiotry.getAll();
    }
    
    public int count() {
        return employeeReposiotry.count();
    }
    
    public void remove(int id) {
        employeeReposiotry.remove(id);
    }
    
    public void update(int id, Employee candidate) {
        employeeReposiotry.update(id, candidate);
    }
}
