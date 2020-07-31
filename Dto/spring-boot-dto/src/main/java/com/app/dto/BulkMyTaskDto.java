package com.app.dto;

import java.util.List;

public class BulkMyTaskDto {
    private List<MyTaskDto> data;

    public List<MyTaskDto> getData() {
        return data;
    }

    public void setData(List<MyTaskDto> data) {
        this.data = data;
    }
}
