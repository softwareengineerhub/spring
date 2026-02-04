package com.example.demopatch.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/my")
public class MyController {

    @PatchMapping("/{id}")
    public String patchById(@PathVariable int id, @RequestBody Person person) {
        String msg = "Patch Response: " + id + ";" + person;
        return msg;
    }

    @PutMapping("/{id}")
    public String putById(@PathVariable int id) {
        String msg = "Put Response: " + id;
        return msg;
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable int id) {
        String msg = "Get Response: " + id;
        return msg;
    }


}
