/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.hibernate.repository.ch01.norelation;

import com.mycompany.my.spring5.hibernate.model.ch01.norelation.Singer;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface SingerDao1 {

    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);

    Singer save(Singer contact);
    
    Singer save2(Singer contact);
    
    void update(Singer contact);

    void delete(Singer contact);

}
