package com.app.model;

public class AccountDto {
    private String name;

    public AccountDto(String name) {
        this.name = name;
    }

    public AccountDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
