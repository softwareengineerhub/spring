/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.app;

import com.jpa.model.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Person p = new Person();
        p.setAge(1);
        p.setName("Name1");
        em.persist(p);
        System.out.println(p);
        
        Person reloaded = em.find(Person.class, p.getId());
        System.out.println(reloaded==null ? "is null" : reloaded);
       
        Person reloadedAgain = em.createQuery("SELECT p FROM Person p WHERE p.id = :id", Person.class).setParameter("id", p.getId()).getSingleResult();
        System.out.println(reloadedAgain==null ? "is null" : reloadedAgain);
        
        em.getTransaction().commit();
    }
    
}
