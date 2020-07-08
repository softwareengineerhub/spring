package com.app.dto;

public class TaskDto {
    private final int id;
    //private final int userId;
    //private final int siteId;
    private final String dataName;

    public TaskDto(int id, String dataName) {
        this.id = id;
      //  this.userId = userId;
    //    this.siteId = siteId;
        this.dataName = dataName;
    }

    public int getId() {
        return id;
    }


    public String getDataName() {
        return dataName;
    }


}
