package com.detaildemo.demo2.entity;

public class DataDetailEntity {
    private int id;
    private String dataId;
    private String propCode;
    private String propValue;
    private String language;
    private String info;

    public DataDetailEntity(String dataId, String propCode, String propValue, String info) {
        this.dataId = dataId;
        this.propCode = propCode;
        this.propValue = propValue;
        this.info = info;
    }
    public DataDetailEntity(String dataId, String propCode, String propValue, String info, String language) {
        this.dataId = dataId;
        this.propCode = propCode;
        this.propValue = propValue;
        this.info = info;
        this.language = language;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", dataId='" + dataId + '\'' +
                ", propCode='" + propCode + '\'' +
                ", propValue='" + propValue + '\'' +
                ", language='" + language + '\'' +
                ", info='" + info + '\'' +
                '}' ;
    }
}
