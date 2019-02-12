/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jpa.data.repository;

import com.mycompany.my.spring5.jpa.data.model.Singer;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface SingerRepository extends CrudRepository<Singer, Integer> {

    List<Singer> findByName(String name);
}
