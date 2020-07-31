package com.app.controller;

import com.app.dto.BulkMyTaskDto;
import com.app.dto.MyTaskDto;
import com.app.mappers.MyTaskMapper;
import com.app.model.MyTask;
import com.app.service.MyTaskService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private MyTaskService myTaskService;

    @GetMapping("/find/{id}")
    public MyTaskDto findById(@PathVariable int id){
        MyTaskMapper taskMapper = MyTaskMapper.INSTANCE;
        return taskMapper.toDto(myTaskService.findById(id));
    }

    @GetMapping("/find-all")
    public List<MyTaskDto> findAll(){
        MyTaskMapper taskMapper = MyTaskMapper.INSTANCE;
        return taskMapper.toDto(myTaskService.findAll());
    }

    @PostMapping("/create")
    public void create(@RequestBody MyTaskDto myTaskDto){
        MyTaskMapper taskMapper = MyTaskMapper.INSTANCE;
        MyTask myTask = taskMapper.toEntity(myTaskDto);
        myTaskService.create(myTask);
    }

    @PostMapping("/create-bulk")
    public void createBulk(@RequestBody List<MyTaskDto> list){
        MyTaskMapper taskMapper = MyTaskMapper.INSTANCE;
        System.out.println("size="+list.size());
        for(MyTaskDto item: list){
            System.out.println(item);
        }
        List<MyTask> myTaskList = taskMapper.toEntity(list);
        for(MyTask myTask: myTaskList) {
            myTaskService.create(myTask);
        }
    }

    @PostMapping("/create-bulk2")
    public void createBulk2(@RequestBody BulkMyTaskDto bulkMyTaskDto){
        MyTaskMapper taskMapper = MyTaskMapper.INSTANCE;
        List<MyTaskDto> list = bulkMyTaskDto.getData();
        System.out.println("size="+list.size());
        for(MyTaskDto item: list){
            System.out.println(item);
        }
        List<MyTask> myTaskList = taskMapper.toEntity(list);
        for(MyTask myTask: myTaskList) {
            myTaskService.create(myTask);
        }
    }

}
