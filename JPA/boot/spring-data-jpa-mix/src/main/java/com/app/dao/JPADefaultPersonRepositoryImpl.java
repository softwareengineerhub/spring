/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import com.app.model.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Repository(value = "jpaDefault")
@Transactional
public class JPADefaultPersonRepositoryImpl implements PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public int size() {
        return em.createQuery("Select count(p) From Person p", Long.class).getSingleResult().intValue();
    }

    @Override
    public Person get(int id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> getAll() {
        return em.createQuery("Select p From Person p", Person.class).getResultList();
    }

    @Override
    public void create(Person person) {
        em.merge(person);
    }

    @Override
    public void createAll(List<Person> persons) {
        for (Person p : persons) {
            em.persist(p);
        }
    }

    @Override
    public void update(int id, Person candidat) {
        Person current = em.find(Person.class, id);
        current.setName(candidat.getName());
        current.setAge(candidat.getAge());
        em.merge(current);
    }

    @Override
    public void remove(int id) {
        Person p = em.find(Person.class, id);
        em.remove(p);
    }

    @Override
    public void removeAll() {
        em.createQuery("Delete From Person p").executeUpdate();
    }

}
