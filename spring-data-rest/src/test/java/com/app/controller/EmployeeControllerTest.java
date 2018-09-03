/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Denys.Prokopiuk
 */
public class EmployeeControllerTest {
    
    @Test
    public void test(){
        ApiClient apiClient = new ApiClientImpl();
        
        int count=apiClient.count();
        assertTrue(count==1);
        
        MyEmployee myEmployee = apiClient.get(0);
        assertNotNull(myEmployee);
        assertTrue(myEmployee.getAge()==1);
        assertTrue("Name1".equals(myEmployee.getName()));
        
        List<MyEmployee> list= apiClient.getAll();
        assertNotNull(list);
        assertTrue(list.size()==1);
        myEmployee = apiClient.get(0);
        assertNotNull(myEmployee);
        assertTrue(myEmployee.getAge()==1);
        assertTrue("Name1".equals(myEmployee.getName()));
        
        MyEmployee emp = new MyEmployee();
        emp.setAge(2);
        emp.setName("Name2");
        apiClient.save(emp);
        
        count=apiClient.count();
        assertTrue(count==2);
        list= apiClient.getAll();
        assertNotNull(list);
        assertTrue(list.size()==2);
        
        count=apiClient.count();        
        apiClient.bulkSave(list);
        assertTrue(count+list.size()==apiClient.count());        
        
        
        MyEmployee candidat = new MyEmployee();
        candidat.setAge(35);
        candidat.setName("Candidat35");
        apiClient.update(0, candidat);
        assertTrue(count+list.size()==apiClient.count());        
        myEmployee = apiClient.get(0);
        assertNotNull(myEmployee);
        assertTrue(myEmployee.getAge()==35);
        assertTrue("Candidat35".equals(myEmployee.getName()));
        
        apiClient.delete(0);
        assertTrue(count+list.size()-1==apiClient.count());        
        myEmployee = apiClient.get(0);
        assertNotNull(myEmployee);
        assertFalse(myEmployee.getAge()==35);
        assertFalse("Candidat35".equals(myEmployee.getName()));        
       
        
        // /readparams/ttt/param
        apiClient = new ApiClientImpl("http://localhost:8081/spring-data-rest/api/v1"+"/readparams/ttt/param");
        Map<String, String> params = new HashMap();
        params.put("a", "aValue");
        apiClient.callWithHeaders(params);
        
    }
    
    
    
    
    
}
