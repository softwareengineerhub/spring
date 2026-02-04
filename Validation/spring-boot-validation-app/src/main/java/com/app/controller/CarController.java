package com.app.controller;

import com.app.domain.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CarController {


    @PostMapping("/car")
    public void create(@Valid @RequestBody Car car) {
        System.out.println("OK; "+car);
    }

    @GetMapping("/car")
    public String get() {
        return "GET";
    }

}
