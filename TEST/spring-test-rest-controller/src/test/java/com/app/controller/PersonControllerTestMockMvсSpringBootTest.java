/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.filter.PersonFilter;
import com.app.model.Person;
import com.app.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 *
 * @author asusadmin
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonControllerTestMockMvсSpringBootTest {
    
    //@Autowired
    //private MockMvc mvc;
    @MockBean
    private PersonRepository personRepository;
    @Autowired
    private TestRestTemplate restTemplate;
    
    private List<Person> persons;

    @Before
    public void init(){
        persons = new ArrayList(); 
        persons.add(new Person("Name0", 0));
        persons.add(new Person("Name1", 1));
        persons.add(new Person("Name2", 2));
    }
    
    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
        // given
        given(personRepository.findAll()).willReturn(persons);        
        
        //when
        ResponseEntity<List> response = restTemplate.getForEntity("/persons/all", List.class);
        
        // then
        assertThat(response.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());        
        assertThat(response.getBody().size()).isEqualTo(persons.size());
    }
    
}
