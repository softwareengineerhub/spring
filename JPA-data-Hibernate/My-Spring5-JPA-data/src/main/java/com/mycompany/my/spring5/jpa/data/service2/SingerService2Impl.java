/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jpa.data.service2;

import com.mycompany.my.spring5.jpa.data.model.Singer;
import com.mycompany.my.spring5.jpa.data.repository.SingerRepository2;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service("springJpaSingerService2")
@Transactional
public class SingerService2Impl implements SingerService2 {

    @Autowired
    private SingerRepository2 singerRepository2;

    @Override
    public List<Singer> findAll() {
        return singerRepository2.findAll();
    }

    @Override
    public List<Singer> findByName(String name) {
        return singerRepository2.findByName(name);
    }

    @Override
    public List<Singer> findLikeName(String name) {
        return singerRepository2.findByNameWithLike(name);
    }

    @Override
    public void save(Singer singer) {
        singerRepository2.save(singer);
    }

}
