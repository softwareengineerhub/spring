/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.dao;

import com.app.model.Log;
import com.app.model.Person;
import java.util.List;

/**
 *
 * @author Denys.Prokopiuk
 */
public interface LogDAO {

    public void save(Log log);

    public int count();

    public List<Log> getAll();

    public void update(String name, Log candidat);

}
