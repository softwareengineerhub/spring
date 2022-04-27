package com.app.component;

import org.springframework.stereotype.Component;

@Component
public class SomeCar {
    private String horsePower = "0 12 * * * ?";

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }
}
