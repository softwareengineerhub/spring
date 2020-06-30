package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;

@Component
public class JobService {

    @Autowired
    private TaskScheduler taskScheduler;
    private Map<Integer, ScheduledFuture> tasks;

    @Autowired
    private ThreadPoolTaskExecutor executor;

    @PostConstruct
    public void init(){
        tasks = new ConcurrentHashMap<>();
    }

    public void makeAction(int id){
        ScheduledFuture sf = taskScheduler.schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println("Single task");
            }
        }, new Date(System.currentTimeMillis()+10000));
        tasks.put(id, sf);
    }

    public void makeAction1(int id){
        ScheduledFuture sf = taskScheduler.schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println("Cron job");
            }
        }, new CronTrigger("00 * * * * *"));
        tasks.put(id, sf);
    }

    public void updateAction1(int id){
        removeAction(id);
        ScheduledFuture sf = taskScheduler.schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println("Cron job-update");
            }
        }, new CronTrigger("00 11,12,13,14,15 * * *"));
        tasks.put(id, sf);
    }

    public void removeAction(int id){
        ScheduledFuture sf = tasks.get(id);
        if(!sf.isDone()){
            sf.cancel(true);
        }
        tasks.remove(id);
    }

}
