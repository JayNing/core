package com.detaildemo.demo2.entity;

/**
 * 查询条件实体类
 */
public class QueryEntity {

    private String propCode;
    private String queryType;
    private String propValue;

    public QueryEntity(String propCode, String queryType, String propValue) {
        this.propCode = propCode;
        this.queryType = queryType;
        this.propValue = propValue;
    }

    public String getPropCode() {
        return propCode;
    }

    public void setPropCode(String propCode) {
        this.propCode = propCode;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }

    @Override
    public String toString() {
        return "QueryEntity{" +
                "propCode='" + propCode + '\'' +
                ", queryType='" + queryType + '\'' +
                ", propValue='" + propValue + '\'' +
                '}';
    }
}
