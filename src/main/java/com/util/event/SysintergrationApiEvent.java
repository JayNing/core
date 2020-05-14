package com.util.event;

import org.springframework.context.ApplicationEvent;

import java.util.Date;

public class SysintergrationApiEvent extends ApplicationEvent {
    private String apiCode;
    private Date startTime;
    private  Integer time;
    private  String requestPayload;
    private  String responePayload;
    private  String status;
    private  String responseStatus;
    public SysintergrationApiEvent(Object source) {
        super(source);
    }

    public SysintergrationApiEvent(Object source, String apiCode, Date startTime, Integer time, String requestPayload, String responePayload, String status, String responseStatus) {
        super(source);
        this.apiCode = apiCode;
        this.startTime = startTime;
        this.time = time;
        this.requestPayload = requestPayload;
        this.responePayload = responePayload;
        this.status = status;
        this.responseStatus = responseStatus;
    }

    public String getApiCode() {
        return apiCode;
    }

    public void setApiCode(String apiCode) {
        this.apiCode = apiCode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getRequestPayload() {
        return requestPayload;
    }

    public void setRequestPayload(String requestPayload) {
        this.requestPayload = requestPayload;
    }

    public String getResponePayload() {
        return responePayload;
    }

    public void setResponePayload(String responePayload) {
        this.responePayload = responePayload;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }
}
