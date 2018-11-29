/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.app.xml;

import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface MyService {

    public void persist(MyPerson myPerson);

    public void delete(MyPerson myPerson);

    public MyPerson update(MyPerson myPerson, int ageFilter, String nameFilter);

    public List<MyPerson> findAll();

    public MyPerson find(String name, int age);

}
