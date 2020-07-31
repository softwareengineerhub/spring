package com.app.dto;

import java.sql.Timestamp;

public class MyTaskDto {

    private String description;
    private String metainfo;
    private Timestamp lastrun;
    private String version;

    public MyTaskDto(String description, String metainfo, Timestamp lastrun) {
        this.description = description;
        this.metainfo = metainfo;
        this.lastrun = lastrun;
    }

    public MyTaskDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetainfo() {
        return metainfo;
    }

    public void setMetainfo(String metainfo) {
        this.metainfo = metainfo;
    }

    public Timestamp getLastrun() {
        return lastrun;
    }

    public void setLastrun(Timestamp lastrun) {
        this.lastrun = lastrun;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "MyTaskDto{" +
                "description='" + description + '\'' +
                ", metainfo='" + metainfo + '\'' +
                ", lastrun=" + lastrun +
                ", version='" + version + '\'' +
                '}';
    }
}
