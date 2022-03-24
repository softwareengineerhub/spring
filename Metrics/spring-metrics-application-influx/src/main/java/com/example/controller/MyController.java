package com.example.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    @Autowired
    private MeterRegistry meterRegistry;
    private List<String> dataList = new ArrayList();
    private Integer myGaugeVal = 0;
    private Timer mytimer;

    @PostConstruct
    public void init(){
        meterRegistry.gaugeCollectionSize("dataList", null, dataList);
        //meterRegistry.gauge("mygauge", myGaugeVal);
        mytimer = meterRegistry.timer("mytimer");
    }

    @GetMapping("/increase")
    public String increase(){
        meterRegistry.counter("hello").increment();
        dataList.add(""+System.currentTimeMillis());
        meterRegistry.gauge("mygauge", ++myGaugeVal);
      //  myGaugeVal++;
        return "increase";
    }

    @GetMapping("/decrease")
    public String decrease(){
        meterRegistry.counter("hello").increment(-1);
        dataList.remove(0);
        meterRegistry.gauge("mygauge", --myGaugeVal);
        //myGaugeVal--;
        return "decrease";
    }

    @Timed("denistime")
    @GetMapping("/maketimer")
    public void makeTimer(){
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis()-start<=2000){

        }
    }

    @GetMapping("/maketimer2")
    public void makeTimer2(){
        mytimer.count();
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis()-start<=2000){
        }
        mytimer.record(Duration.ofMillis(System.currentTimeMillis()-start));
    }


    @GetMapping("/counter-tag-increment")
    public String counterTag(){
        //meterRegistry.counter("hello", "tagA").increment();
        return "counterTag";
    }


    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }




}
