package com.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/action")
    public String doAction(){
        return "action";
    }

    @GetMapping("/action1")
    public String doAction1(){
        return "action1";
    }

    @GetMapping("/action2")
    public String doAction2(){
        return "action2";
    }

    @GetMapping("/action3")
    public String doAction3(){
        return "action3";
    }

}
