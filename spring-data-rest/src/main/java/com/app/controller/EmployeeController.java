/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Employee;
import com.app.repository.EmployeeReposiotry;
import com.app.service.EmployeeService;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Denys.Prokopiuk
 */
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostConstruct
    public void init() {
        Employee emp = new Employee();
        emp.setAge(1);
        emp.setName("Name1");
        employeeService.add(emp);
    }

    @RequestMapping(value = "/count", method = GET)
    public int count() {
        return employeeService.count();
    }

    @RequestMapping(method = POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void save(@RequestBody Employee employee) {
        employeeService.add(employee);
    }

    @RequestMapping(value = {"/bulk"}, method = POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public void bulkSave(@RequestBody List<Employee> employees) {
        employeeService.addAll(employees);
    }

    @RequestMapping(value = "/{id}", method = GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Employee get(@PathVariable(value = "id") int id) {
        return employeeService.get(id);
    }

    @RequestMapping(method = GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public void delete(@PathVariable("id") int id) {
        employeeService.remove(id);
    }

    @RequestMapping(value = "/{id}", method = PUT)
    public void update(@PathVariable("id") int id, @RequestBody Employee candidate) {
        employeeService.update(id, candidate);
    }
    
    @GetMapping(value = "/readparams/ttt/param")
    public void readParam(@RequestParam(value="a", required = false) String a){
        System.out.println("a="+a);
    }

}
