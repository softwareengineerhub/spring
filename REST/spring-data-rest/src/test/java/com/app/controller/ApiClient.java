/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.controller;

import com.app.model.Employee;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface ApiClient {

    public int count();

    public List<MyEmployee> getAll();

    public MyEmployee get(int id);

    public void save(MyEmployee employee);

    public void bulkSave(List<MyEmployee> employees);

    public void update(int id, MyEmployee candidat);

    public void delete(int id);

    public void callWithParams(Map<String, String> params);

    public void callWithHeaders(Map<String, String> params);

}
