/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jpa.data.repository;

import com.mycompany.my.spring5.jpa.data.model.Singer;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface SingerRepository2 extends JpaRepository<Singer, Integer> {

    List<Singer> findByName(String name);

    @Query("select s from Singer s where s.name like %:name%")
    List<Singer> findByNameWithLike(@Param("name") String name);

}
