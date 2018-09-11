/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import org.junit.Test;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyControllerTest {

    @Test
    public void test() {
        ApiClient apiClient = new ApiClientImpl("http://localhost:8081/spring-data-rest/api/v1/a/b/c/d/e/testsave");
        MyEmployee emp = new MyEmployee();
        emp.setAge(12);
        emp.setName("Name12");
        apiClient.save(emp);
    }
    
}
