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
public interface MyRepository {

    public void save(MyPerson myPerson);

    public void remove(MyPerson myPerson);

    public List<MyPerson> readAll();

    public MyPerson read(String name, int age);

    public MyPerson update(MyPerson updateCandidat, MyPerson filter);

}
