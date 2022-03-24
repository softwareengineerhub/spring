package com.example.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MySchedule {

  //  @Scheduled(fixedRate = 5000)
    public void makeAction(){
        System.out.println("makeAction(); "+new Date());
    }

}
