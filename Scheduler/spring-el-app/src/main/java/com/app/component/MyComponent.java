package com.app.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyComponent {

    @Scheduled(cron = "#{someCar.horsePower}")
    public void doAction(){
        System.out.println("doAction");
    }

    //@Value("${some.key:my default value}")
    @Scheduled(fixedRateString = "#{${some.key:3000}}")
    public void doAction2(){
        System.out.println("doAction2; "+ new Date());
    }

}
