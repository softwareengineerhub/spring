/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jpa.data.service2;

import com.mycompany.my.spring5.jpa.data.model.Singer;
import java.util.List;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface SingerService2 {

    List<Singer> findAll();

    List<Singer> findByName(String name);

    List<Singer> findLikeName(String name);

    public void save(Singer singer);

}
