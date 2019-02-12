/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.jpa.repository;

import com.mycompany.my.spring5.jpa.model.Singer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Repository
@Transactional
@Service("jpaSingerService")
public class SingerServiceImpl implements SingerService {
    
    @PersistenceContext
    private EntityManager em;
    
    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return em.createQuery("select s from Singer s", Singer.class).getResultList();
    }
    
    @Override
    public void save(Singer singer) {
        em.persist(singer);
    }
    
}
