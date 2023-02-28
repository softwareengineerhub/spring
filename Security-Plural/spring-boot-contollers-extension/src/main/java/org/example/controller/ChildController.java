package org.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/child")
public class ChildController extends ParentController {

    /*@GetMapping
    public String get(){
        String s = "parent.get()";
        System.out.println(s);
        return s;
    }*/

    public String get(){
        System.out.println("qqqq");
        return "qqqq";
    }


    public String get2(){
        System.out.println("!!!!Child");
        return super.get2();
    }

    /*public String get(){
        System.out.println("qqqq");
        return "qqqq";
    }*/
}
