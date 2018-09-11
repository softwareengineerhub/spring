/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 *
 * @author Denys.Prokopiuk
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyTestConfig.class})
@WebAppConfiguration
public class PersonControllerIntegrationTest {
 
  //  @Autowired
    private MockMvc mockMvc;
    
  //  @Test
    public void test() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/count");
        ResultActions res=mockMvc.perform(requestBuilder);
        Object resObj=res.andReturn().getHandler();
        System.out.println("resObj="+resObj);
    }
    
}
