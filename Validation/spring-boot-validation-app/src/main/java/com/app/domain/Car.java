package com.app.domain;


import javax.validation.constraints.Pattern;

public class Car {

    @Pattern( regexp = "['\"]" )
    //['\\\"]
    //@Pattern(regexp = "['\\\"]")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                '}';
    }
}
