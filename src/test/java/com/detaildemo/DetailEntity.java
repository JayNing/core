package com.detaildemo;

public class DetailEntity {
    private int id;
    private String dataId;
    private String propCode;
    private String propValue;
    private String info;

    public DetailEntity(String dataId, String propCode, String propValue, String info) {
        this.dataId = dataId;
        this.propCode = propCode;
        this.propValue = propValue;
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getPropCode() {
        return propCode;
    }

    public void setPropCode(String propCode) {
        this.propCode = propCode;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", dataId='" + dataId + '\'' +
                ", propCode='" + propCode + '\'' +
                ", propValue='" + propValue + '\'' +
                ", info='" + info + '\'' +
                '}' ;
    }
}
