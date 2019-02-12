/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.my.spring5.hibernate.main;

import com.mycompany.my.spring5.hibernate.config.AppConfig;
import com.mycompany.my.spring5.hibernate.model.ch01.norelation.Singer;
import com.mycompany.my.spring5.hibernate.repository.ch01.norelation.SingerDao1;
import com.mycompany.my.spring5.hibernate.repository.ch01.norelation.SingerService1;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SingerDao1 singerDao1 = ctx.getBean(SingerDao1.class);
        Singer singer = new Singer();
        singer.setFirstName("Test1");
        singer.setLastName("Test2");
        singer.setVersion(1);
        singer.setBirthDate(new Date());
        singerDao1.save(singer);
        List<Singer> list = singerDao1.findAll();
        System.out.println("Singer.count=" + list.size());
        for (Singer item : list) {
            System.out.println("\t" + item);
        }
        System.out.println("------SAVE BULK------");
        SingerService1 service1 = ctx.getBean(SingerService1.class);
        Singer a = new Singer();
        Singer b = new Singer();
        Singer c = new Singer();
        a.setFirstName("A");
        b.setFirstName("B");
        c.setFirstName("C");
        service1.processSingers(a, b, c);
    }

}
