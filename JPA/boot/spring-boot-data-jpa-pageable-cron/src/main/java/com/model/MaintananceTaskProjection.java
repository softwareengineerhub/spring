package com.model;

public interface MaintananceTaskProjection {

    public long getId();

    public String getDevice();

    public String getPartname();

    public int getTaskid();

    public int getPriority();

    public String getRuledescription();

    public String getSite();

    public String getMailto();

    public String getMailcc();

    public String getMailbody();

    public int getMax();
}
