/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.nospring.spring5.jdbc.dao;

import com.ch01.nospring.spring5.jdbc.model.Singer;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface SingerDao {

    List<Singer> findAll();

    List<Singer> findByFirstName(String firstName);

    String findLastNameById(Long id);

    String findFirstNameById(Long id);

    void insert(Singer singer);

    void update(Singer singer);

    void delete(Long singerId);

    List<Singer> findAllWithDetail();

    void insertWithDetail(Singer singer);
}
