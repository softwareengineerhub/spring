/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.spring5.jta.datasources.app;

import org.spring5.jta.datasources.config.AppConfig;
import org.spring5.jta.datasources.model.Company;
import org.spring5.jta.datasources.model.Employee;
import org.spring5.jta.datasources.service.BusinessService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class AppMain {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BusinessService businessService = ctx.getBean(BusinessService.class);
        
        Employee emp = new Employee();
        emp.setAge(10);
        emp.setName("Emp1");
        
        Company company = new Company();        
        company.setCompanyName("CompanyA");
        
        businessService.process(emp, company);
    }
    
}
