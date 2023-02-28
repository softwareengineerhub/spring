package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @GetMapping
    public String get(){
        String s = "parent.get()";
        System.out.println(s);
        return s;
    }

    @GetMapping("/get2")
    public String get2(){
        String s = "parent.get2()";
        System.out.println(s);
        return s;
    }
}
