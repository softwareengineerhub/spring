/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jpa.data.service;

import com.mycompany.my.spring5.jpa.data.model.Singer;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface SingerService {

    List<Singer> findAll();

    List<Singer> findByName(String name);

    public void save(Singer singer);

}
