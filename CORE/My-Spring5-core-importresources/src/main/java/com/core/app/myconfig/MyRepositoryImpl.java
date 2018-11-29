/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.core.app.myconfig;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Denys.Prokopiuk
 */
public class MyRepositoryImpl implements MyRepository {

    private List<MyPerson> data;

    public MyRepositoryImpl() {
        data = new ArrayList<>();
    }
    
    @Override
    public void save(MyPerson myPerson) {
        data.add(myPerson);
    }

    @Override
    public void remove(MyPerson myPerson) {
        data.remove(myPerson);
    }

    @Override
    public List<MyPerson> readAll() {
        return data;
    }

    @Override
    public MyPerson read(String name, int age) {
        for(int i=0;i<data.size();i++){
            if(data.get(i).getAge()==age){
                if(name!=null && name.equals(data.get(i).getName())){
                    return data.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public MyPerson update(MyPerson updateCandidat, MyPerson filter) {
        for(int i=0;i<data.size();i++){
            if(data.get(i).getAge()==filter.getAge()){
                if(data.get(i)!=null && data.get(i).equals(filter.getName())){
                    return data.set(i, updateCandidat);
                }
            }
        }
        return null;
    }
    
}
