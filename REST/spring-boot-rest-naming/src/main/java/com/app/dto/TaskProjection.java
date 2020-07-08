package com.app.dto;

import org.springframework.beans.factory.annotation.Value;

public interface TaskProjection {

    public int getId();

    //public int getUserId();

    @Value("#{target.site.id}")
    public Integer getSiteId();

    public String getDataName();

    Integer getTaskId();
}
