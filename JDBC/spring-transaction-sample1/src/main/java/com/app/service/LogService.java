/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service;

import com.app.dao.LogDAO;
import com.app.dao.PersonDAO;
import com.app.model.Log;
import com.app.model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Denys.Prokopiuk
 */
@Service(value = "logService")
@Transactional
public class LogService implements MyService {
    
    @Autowired
    private LogDAO logDao;

    
    @Override
    public void makeAction() {
        int count = logDao.count();
        System.out.println("count=" + count);
        System.out.println("--------------------------");
        List<Log> logs = logDao.getAll();
        for (Log log : logs) {
            System.out.println(log);
        }
        System.out.println("--------------------------");
        System.out.println("--------------------------");      
        Log log = new Log();        
        log.setLine("Name1");
        logDao.save(log);
        
        System.out.println("count=" + logDao.count());
        Log candidat = new Log();        
        candidat.setLine("Name1-Update");
        logDao.update("Name1", candidat);
        if(1<2){
            //throw new RuntimeException("Test exception");
        }
    }
    
}
