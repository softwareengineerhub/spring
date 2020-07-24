package com.controller;

import java.sql.Timestamp;

public class MyResponse {
    private Timestamp tovalue;
    private Timestamp fromvalue;

    public Timestamp getTovalue() {
        return tovalue;
    }

    public void setTovalue(Timestamp tovalue) {
        this.tovalue = tovalue;
    }

    public Timestamp getFromvalue() {
        return fromvalue;
    }

    public void setFromvalue(Timestamp fromvalue) {
        this.fromvalue = fromvalue;
    }

    @Override
    public String toString() {
        return "MyResponse{" +
                "tovalue=" + tovalue +
                ", fromvalue=" + fromvalue +
                '}';
    }
}
