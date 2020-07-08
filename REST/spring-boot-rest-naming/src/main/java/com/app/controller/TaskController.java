package com.app.controller;

import com.app.dto.TaskDto;
import com.app.dto.TaskProjection;
import com.app.entity.Site;
import com.app.entity.Task;
import com.app.entity.User;
import com.app.repository.SiteRepository;
import com.app.repository.TaskRepository;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private SiteRepository siteRepository;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init() {
        initUsers();
        initSites();
        initTasks();
    }

    @GetMapping("/task")
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @GetMapping("/taskprojection")
    public List<TaskProjection> findAllProjection() {
        return taskRepository.findAllTasksProjection();
    }

    @GetMapping("/task2")
    public List<TaskProjection> findAll2() {
        return taskRepository.findAllTasks(1);
    }

    @GetMapping("/task3")
    public List<TaskDto> findAll3() {
        return taskRepository.findAllTasks();
    }

    @GetMapping("/mytask/max/siteid/{site-id}")
    public Integer findMaxTaskIdBySite(@PathVariable("site-id") int siteId) {
        Integer res = taskRepository.findMaxTaskIdBySite(siteId);
        System.out.println("res="+res);
        return res;
    }

    @GetMapping("/mytask")
    public List<TaskProjection> findAllTasks() {
        return taskRepository.findAllTasksProjection();
    }

    @GetMapping("/mytask/{task-id}")
    public TaskProjection findTaskById(@PathVariable("task-id") int taskId) {
        return taskRepository.findTasksProjectionById(taskId);
    }

    private void initTasks(){
        Task task = new Task();
        task.setId(1);
        task.setSite(siteRepository.findById(1).get());
        task.setDataName("Task1");
        task.setUser(userRepository.findById(1).get());
        task.setTaskId(1);
        taskRepository.save(task);

        task = new Task();
        task.setId(2);
        task.setSite(siteRepository.findById(2).get());
        task.setDataName("Task2");
        task.setTaskId(1);
        task.setUser(userRepository.findById(2).get());
        taskRepository.save(task);
    }

    private void initSites() {
        Site site = new Site();
        site.setId(1);
        site.setTitle("Site1");
        siteRepository.save(site);
        site = new Site();
        site.setId(2);
        site.setTitle("Site2");
        siteRepository.save(site);
    }


    private void initUsers() {
        User user = new User();
        user.setId(1);
        user.setName("User1");
        userRepository.save(user);
        user = new User();
        user.setId(2);
        user.setName("User2");
        userRepository.save(user);
    }

}
