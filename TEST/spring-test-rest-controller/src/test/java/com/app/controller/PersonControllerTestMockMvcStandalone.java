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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 *
 * @author asusadmin
 */
@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTestMockMvcStandalone {
    
    private MockMvc mvc;
    @Mock
    private PersonRepository personRepository;
    @InjectMocks
    private PersonController superHeroController;
    private List<Person> persons;
    private ObjectMapper mapper;

    @Before
    public void init(){
         mvc = MockMvcBuilders.standaloneSetup(superHeroController)
               //.setControllerAdvice(new SuperHeroExceptionHandler())
                .addFilters(new PersonFilter())
                .build();
        persons = new ArrayList(); 
        persons.add(new Person("Name0", 0));
        persons.add(new Person("Name1", 1));
        persons.add(new Person("Name2", 2));
        mapper = new ObjectMapper();
    }
    
    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
        // given
        given(personRepository.findAll()).willReturn(persons);

        // when
        MockHttpServletResponse response = mvc.perform(get("/persons/all")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(mapper.writeValueAsString(persons));
    }
    
}
