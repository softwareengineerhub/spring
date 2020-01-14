/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.repository.pagination;

import com.model.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author asusadmin
 */
public interface PersonPaginationRepository extends JpaRepository<Person, Integer>  {

    Slice<Person> findByName(String name, Pageable page);

}
