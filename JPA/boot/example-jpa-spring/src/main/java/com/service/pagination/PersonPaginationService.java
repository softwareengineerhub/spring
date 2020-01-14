/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service.pagination;

import com.model.Person;
import com.repository.pagination.PersonPaginationRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

/**
 *
 * @author asusadmin
 */
@Service
@Transactional
public class PersonPaginationService {

    @Autowired
    private PersonPaginationRepository repository;

    public List<Person> doAction(String name, int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        Slice<Person> slice = repository.findByName(name, pageable);
        return slice.getContent();
    }

    public List<Person> doAction2(String name, int pageNumber, int size) {
        Pageable pageable = PageRequest.of(pageNumber, size);
        Slice<Person> slice = repository.findByName(name, pageable);
        pageable = slice.nextPageable();
        return slice.getContent();
    }

    public void save(Person p) {
        repository.save(p);
    }
    
    public void deleteAll(){
        repository.deleteAll();
    }

}
