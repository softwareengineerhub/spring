package com.model;

public class MaintananceTaskDto  {
    private long id;
    private String device;
    private String partname;
    private int taskid;
    private int priority;
    //private Date to;
    //private Date from;
    private String ruledescription;
    private String site;
    private String mailto;
    private String mailcc;
    private String mailbody;

    public MaintananceTaskDto(long id, String device, String partname, int taskid, int priority, String ruledescription, String site, String mailto, String mailcc, String mailbody) {
        this.id = id;
        this.device = device;
        this.partname = partname;
        this.taskid = taskid;
        this.priority = priority;
        this.ruledescription = ruledescription;
        this.site = site;
        this.mailto = mailto;
        this.mailcc = mailcc;
        this.mailbody = mailbody;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getPartname() {
        return partname;
    }

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getRuledescription() {
        return ruledescription;
    }

    public void setRuledescription(String ruledescription) {
        this.ruledescription = ruledescription;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getMailto() {
        return mailto;
    }

    public void setMailto(String mailto) {
        this.mailto = mailto;
    }

    public String getMailcc() {
        return mailcc;
    }

    public void setMailcc(String mailcc) {
        this.mailcc = mailcc;
    }

    public String getMailbody() {
        return mailbody;
    }

    public void setMailbody(String mailbody) {
        this.mailbody = mailbody;
    }
}
