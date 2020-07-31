package com.app.service;

import com.app.model.MyTask;
import com.app.repository.MyTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
@Transactional
public class MyTaskService {

    @Autowired
    private MyTaskRepository myTaskRepository;

    public List<MyTask> findAll(){
        return myTaskRepository.findAll();
    }

    public void update(int id){
        MyTask myTask = myTaskRepository.findTask(id);
        myTask.setLastrun(new Timestamp(System.currentTimeMillis()));
        myTaskRepository.saveAndFlush(myTask);
    }

    public MyTask create(MyTask myTask){
        return myTaskRepository.save(myTask);
    }

    public MyTask findById(int id){
        return myTaskRepository.findTask(id);
    }

}
