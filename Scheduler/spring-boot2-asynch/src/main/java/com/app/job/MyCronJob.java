package com.app.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyCronJob {
    private DateFormat dateFormat = new SimpleDateFormat();

    @Scheduled(cron = "*/10 * * * * *")
    public void makeAction(){
        System.out.println("job is running: "+dateFormat.format(new Date()));
    }
}
