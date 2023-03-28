package com.app.controller;

import com.app.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/select")
public class SelectController {
    @Autowired
    private MyService myService;

    @GetMapping()
    public void get(@RequestParam("delay") long delay, @RequestParam("id") int id) {
        myService.process(delay, id);
    }

}
