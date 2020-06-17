/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject19;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author asusadmin
 */
public class Main {
    
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("com.mycompany_mavenproject19_jar_1.0-SNAPSHOTPU").createEntityManager();
        em.getTransaction().begin();
        
        Site site = new Site();
        site.setNameOfSite("site2");
        em.persist(site);
        
        Device device = new Device();
        device.setName("device2");
        device.setSite(site);
        em.persist(device);
        
        MaintanaceTask mt = new MaintanaceTask();
        mt.setTitle("mt2");
        mt.setPriority(2);
        mt.setDevice(device);
        em.persist(mt);
        
        mt = new MaintanaceTask();
        mt.setTitle("mt22");
        mt.setPriority(22);
        mt.setDevice(device);
        em.persist(mt);
        
        device = new Device();
        device.setName("device1");
        device.setSite(site);
        em.persist(device);
        
        mt = new MaintanaceTask();
        mt.setTitle("mt1");
        mt.setPriority(1);
        mt.setDevice(device);
        em.persist(mt);
        
        mt = new MaintanaceTask();
        mt.setTitle("mt11");
        mt.setPriority(11);
        mt.setDevice(device);
        em.persist(mt);
        
        em.getTransaction().commit();
        
        
        
        
        System.out.println("-----filterByDevice-----");
        filterByDevice(em);
        System.out.println("-----filterByPriority-----");
        filterByPriority(em);
        System.out.println("-----filterByDeviceAndPriority-----");
        filterByDeviceAndPriority(em);   
        
        System.out.println("-----filterSiteIdByName-----");
        filterSiteIdByName(em);
        System.out.println("-----filterDeviceBySide-----");
        filterDeviceBySide(em);
        System.out.println("-----filterBySite-----");
        filterBySite(em);   
        System.out.println("-----filterBySiteAndPriority-----");
        filterBySiteAndPriority(em);   
        System.out.println("-----filterBySiteAndDevice-----");
        filterBySiteAndDevice(em);
        System.out.println("-----filter-----");
        filter(em);
    }
    
    
    private static void filter(EntityManager em){
        em.getTransaction().begin();
        TypedQuery<MaintanaceTask> tq = em.createQuery("SELECT mt FROM MaintanaceTask mt JOIN mt.device d WHERE mt.priority=1 AND d.name='device1' AND d.id in (SELECT d.id FROM Device d JOIN d.site s WHERE s.nameOfSite='site2')", MaintanaceTask.class);
        List<MaintanaceTask> res = tq.getResultList();
        System.out.println("res.size="+res.size());
        for(MaintanaceTask task: res){
            System.out.println(task);
        }
        em.getTransaction().commit();
    }
    
    private static void filterBySiteAndDevice(EntityManager em){
        em.getTransaction().begin();
        TypedQuery<MaintanaceTask> tq = em.createQuery("SELECT mt FROM MaintanaceTask mt JOIN mt.device d WHERE d.name='device1' AND d.id in (SELECT d.id FROM Device d JOIN d.site s WHERE s.nameOfSite='site2')", MaintanaceTask.class);
        List<MaintanaceTask> res = tq.getResultList();
        System.out.println("res.size="+res.size());
        for(MaintanaceTask task: res){
            System.out.println(task);
        }
        em.getTransaction().commit();
    }
    
    private static void filterBySiteAndPriority(EntityManager em){
        em.getTransaction().begin();
        TypedQuery<MaintanaceTask> tq = em.createQuery("SELECT mt FROM MaintanaceTask mt JOIN mt.device d WHERE mt.priority=1 AND d.id in (SELECT d.id FROM Device d JOIN d.site s WHERE s.nameOfSite='site2')", MaintanaceTask.class);
        List<MaintanaceTask> res = tq.getResultList();
        System.out.println("res.size="+res.size());
        for(MaintanaceTask task: res){
            System.out.println(task);
        }
        em.getTransaction().commit();
    }
    
    
    private static void filterBySite(EntityManager em){
        em.getTransaction().begin();
        TypedQuery<MaintanaceTask> tq = em.createQuery("SELECT mt FROM MaintanaceTask mt JOIN mt.device d WHERE d.id in (SELECT d.id FROM Device d JOIN d.site s WHERE s.nameOfSite='site2')", MaintanaceTask.class);
        List<MaintanaceTask> res = tq.getResultList();
        System.out.println("res.size="+res.size());
        for(MaintanaceTask task: res){
            System.out.println(task);
        }
        em.getTransaction().commit();
    }
    
    private static void filterDeviceBySide(EntityManager em){
        em.getTransaction().begin();
        //SELECT mt FROM MaintanaceTask mt JOIN mt.device d WHERE d.id in (1,2)
        TypedQuery<Device> tq = em.createQuery("SELECT d FROM Device d JOIN d.site s WHERE s.id=1", Device.class);
        List<Device> res = tq.getResultList();
        System.out.println("res.size="+res.size());
        for(Device task: res){
            System.out.println(task);
        }
        em.getTransaction().commit();
    }
    
    private static void filterSiteIdByName(EntityManager em){
        em.getTransaction().begin();
        //SELECT mt FROM MaintanaceTask mt JOIN mt.device d WHERE d.id in (1,2)
        TypedQuery<Integer> tq = em.createQuery("SELECT s.id FROM Site s WHERE s.nameOfSite='site2'", Integer.class);
        List<Integer> res = tq.getResultList();
        System.out.println("res.size="+res.size());
        for(int task: res){
            System.out.println(task);
        }
        em.getTransaction().commit();
    }
    
    
    
    private static void filterByDeviceAndPriority(EntityManager em){
        em.getTransaction().begin();
        TypedQuery<MaintanaceTask> tq = em.createQuery("SELECT mt FROM MaintanaceTask mt JOIN mt.device d WHERE d.id=2 and mt.priority=22", MaintanaceTask.class);
        List<MaintanaceTask> res = tq.getResultList();
        System.out.println("res.size="+res.size());
        for(MaintanaceTask task: res){
            System.out.println(task);
        }
        em.getTransaction().commit();
    }
    
    
    private static void filterByPriority(EntityManager em){
        em.getTransaction().begin();
        TypedQuery<MaintanaceTask> tq = em.createQuery("SELECT mt FROM MaintanaceTask mt WHERE mt.priority=2", MaintanaceTask.class);
        List<MaintanaceTask> res = tq.getResultList();
        System.out.println("res.size="+res.size());
        for(MaintanaceTask task: res){
            System.out.println(task);
        }
        em.getTransaction().commit();
    }
    
    private static void filterByDevice(EntityManager em){
        //SELECT p FROM Professor e JOIN e.phones p
        //TypedQuery<MaintanaceTask> tq = em.createQuery("SELECT mt FROM MaintanaceTask d JOIN d.device mt", MaintanaceTask.class);
        //TypedQuery<MaintanaceTask> tq = em.createQuery("SELECT mt FROM MaintanaceTask mt WHERE mt.device=2", MaintanaceTask.class);     
        
        em.getTransaction().begin();
        TypedQuery<MaintanaceTask> tq = em.createQuery("SELECT mt FROM MaintanaceTask mt JOIN mt.device d WHERE d.name='device2'", MaintanaceTask.class);
        List<MaintanaceTask> res = tq.getResultList();
        System.out.println("res.size="+res.size());
        for(MaintanaceTask task: res){
            System.out.println(task);
        }
        em.getTransaction().commit();
    }
    
}
