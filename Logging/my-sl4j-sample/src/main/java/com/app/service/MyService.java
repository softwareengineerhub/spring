package com.app.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class MyService {


    public void doAction(){

        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.info("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");

        log.info("Hello, {}", "Denis");
        MyData md = new MyData();
        log.info("Data, {}", md.data);

        MyData md1 = new MyData();
        md1.setData(10L);
        Object erid = new Object();
        log.info("Reassociating recovery id from non existing to {}; ExternalRecoveryId={}", md1.getData(), erid.toString());
    }

}
