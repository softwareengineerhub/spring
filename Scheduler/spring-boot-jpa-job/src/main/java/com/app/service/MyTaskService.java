package com.app.service;

import com.app.model.MyTask;
import com.app.repository.MyTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@Transactional
public class MyTaskService {

    @Autowired
    private MyTaskRepository myTaskRepository;

    public void update(int id){
        MyTask myTask = myTaskRepository.findTask(id);
        myTask.setLastrun(new Timestamp(System.currentTimeMillis()));
        myTaskRepository.saveAndFlush(myTask);
        //myTaskRepository.updateRunningTime(new Timestamp(System.currentTimeMillis()), id);
    }

    public MyTask create(MyTask myTask){
        return myTaskRepository.save(myTask);
    }

    public MyTask findById(int id){
        return myTaskRepository.findTask(id);
    }

}
