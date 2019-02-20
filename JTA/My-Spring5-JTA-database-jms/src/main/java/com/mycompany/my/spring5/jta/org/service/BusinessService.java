/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jta.org.service;

import javax.transaction.Transactional;
import com.mycompany.my.spring5.jta.org.model.Company;
import com.mycompany.my.spring5.jta.org.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service
@Transactional
public class BusinessService {

    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private NotificationServiceXA notificationService;
    @Autowired
    private NotificationServiceXAWithTemplate notificationServiceXAWithTemplate;

    public void process(Employee employee, Company company) {
        notificationService.makeNotification();
        notificationServiceXAWithTemplate.makeNotification();
        companyService.save(company);
        employeeService.save(employee);       
        
    }
}
