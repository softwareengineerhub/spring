/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyHeaderControllerTest {
    
    @Test
    public void test() {
        ApiClient apiClient = new ApiClientImpl("http://localhost:8081/spring-data-rest/api/v1/header/readheader");
        Map<String, String> params = new HashMap();
        params.put("userName", "userNameValue");
        apiClient.callWithHeaders(params);
    }
    
}
