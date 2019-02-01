/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch02.spring.spring5.jdbc;

import com.ch01.nospring.spring5.jdbc.model.Album;
import com.ch01.nospring.spring5.jdbc.model.Singer;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main3 {
    
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        MySingerTemplateDao mySingerTemplateDao = ctx.getBean(MySingerTemplateDao.class);
        List<Singer> list = mySingerTemplateDao.findAllWithDetail();
        for (Singer s : list) {
            System.out.println("----------------------------");
            System.out.println(s);
            for (Album a : s.getAlbums()) {
                System.out.println("\t" + a);
            }
            System.out.println("----------------------------");
        }
    }
    
}
