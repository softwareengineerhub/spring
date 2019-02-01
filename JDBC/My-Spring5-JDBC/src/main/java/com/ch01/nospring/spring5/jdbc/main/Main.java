/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ch01.nospring.spring5.jdbc.main;

import com.ch01.nospring.spring5.jdbc.dao.PlainSingerDao;
import com.ch01.nospring.spring5.jdbc.dao.SingerDao;
import com.ch01.nospring.spring5.jdbc.model.Album;
import com.ch01.nospring.spring5.jdbc.model.Singer;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public class Main {
    
    public static void main(String[] args) {
        SingerDao singerDao = new PlainSingerDao();
        List<Singer> list = singerDao.findAllWithDetail();
        for(Singer s: list){
            System.out.println("----------------------------");
            System.out.println(s);
            for(Album a: s.getAlbums()){
                System.out.println("\t"+a);
            }
            System.out.println("----------------------------");
        }
    }
    
}
