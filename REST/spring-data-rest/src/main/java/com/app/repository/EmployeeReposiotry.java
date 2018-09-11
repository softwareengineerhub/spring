/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.repository;

import com.app.model.Employee;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Denys.Prokopiuk
 */
@Repository
public class EmployeeReposiotry {

    private List<Employee> employees = new ArrayList();

    public void add(Employee employee) {
        employees.add(employee);
    }

    public void addAll(List<Employee> employees) {
        this.employees.addAll(employees);
    }

    public Employee get(int id) {
        return employees.get(id);
    }

    public int count() {
        return employees.size();
    }

    public List<Employee> getAll() {
        return employees;
    }

    public void remove(int id) {
        employees.remove(id);
    }

    public void update(int id, Employee candidate) {
        employees.set(id, candidate);
    }

}
