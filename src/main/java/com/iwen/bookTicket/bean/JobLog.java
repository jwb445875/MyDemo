package com.iwen.bookTicket.bean;

import java.io.Serializable;
import java.util.Date;

public class JobLog implements Serializable {

    private Integer id;
    private String jobDesc;
    private Date startTime;
    private Date endTime;
    private String exeStatus;
    private String exeIp;
    private String errorInfo;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getExeStatus() {
        return exeStatus;
    }

    public void setExeStatus(String exeStatus) {
        this.exeStatus = exeStatus;
    }

    public String getExeIp() {
        return exeIp;
    }

    public void setExeIp(String exeIp) {
        this.exeIp = exeIp;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }
}