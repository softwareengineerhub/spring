/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.hibernate.repository.ch01.norelation;

import com.mycompany.my.spring5.hibernate.model.ch01.norelation.Singer;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Transactional
@Repository("singerDao")
public class SingerDao1Impl implements SingerDao1 {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Singer> findAll() {
        return sessionFactory.getCurrentSession().createQuery("from Singer s").list();
    }

    @Override
    public List<Singer> findAllWithAlbum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Singer findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public Singer save(Singer contact) {
        long id = (long) sessionFactory.getCurrentSession().save(contact);
        contact.setId(id);
        return contact;
    }

    @Override
    public void delete(Singer contact) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Transactional
    @Override
    public Singer save2(Singer contact) {
        throw new RuntimeException("Test exception");
    }

    @Override
    public void update(Singer contact) {
        sessionFactory.getCurrentSession().update(this);    
    }
    

}
