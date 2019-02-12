/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jpa.data.service;

import com.mycompany.my.spring5.jpa.data.model.Singer;
import com.mycompany.my.spring5.jpa.data.repository.SingerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Lists;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service("springJpaSingerService")
@Transactional
public class SingerServiceImpl implements SingerService {

    @Autowired
    private SingerRepository singerRepository;

    @Override
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findByName(String name) {
        return Lists.newArrayList(singerRepository.findByName(name));
    }

    @Override
    public void save(Singer singer) {
        singerRepository.save(singer);
    }

}
