package com.app;

import com.app.model.MyTask;
import com.app.service.MyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
    @Autowired
    private MyTaskService myTaskService;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    public void run(String... args) throws Exception {
        MyTask myTask = new MyTask();
        myTask.setDescription("description1");
        myTask.setMetainfo("metainfo1");
        myTask = myTaskService.create(myTask);

        myTask = new MyTask();
        myTask.setDescription("description2");
        myTask.setMetainfo("metainfo2");
        myTask = myTaskService.create(myTask);

       // myTaskService.update(myTask.getId());
       // myTask = myTaskService.findById(1);
       // System.out.println(myTask);
    }
}
