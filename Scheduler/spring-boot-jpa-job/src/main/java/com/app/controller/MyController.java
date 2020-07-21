package com.app.controller;

import com.app.service.MyTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MyController {

    @Autowired
    private MyTaskService myTaskService;

    @GetMapping("/update")
    public void create(HttpServletRequest request){
        int id = Integer.parseInt(request.getParameter("id"));
        Runnable r = ()->{
            try {
                myTaskService.update(id);
            } catch(Exception ex){
                System.out.println(ex.getMessage());
            }
        };

        new Thread(r).start();
        new Thread(r).start();
    }

}
