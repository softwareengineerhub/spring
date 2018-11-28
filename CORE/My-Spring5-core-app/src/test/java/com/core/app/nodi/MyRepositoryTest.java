/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.app.nodi;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyRepositoryTest {

    @Test
    public void hello() {
        MyRepository myRepository = new MyRepositoryImpl();
        myRepository.save(new MyPerson("p0", 0));        
        myRepository.save(new MyPerson("p1", 1));        
        myRepository.save(new MyPerson("p2", 2));
        List<MyPerson> list =  myRepository.readAll();
        assertTrue(list.size()==3);        
    }
}
