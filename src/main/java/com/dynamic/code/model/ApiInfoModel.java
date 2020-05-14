package com.dynamic.code.model;

import java.util.List;

/**
 * @author Page.Yang
 * @date 2019/5/6 0006
 */
public class ApiInfoModel extends ApiInfo {

    /**
     * 数据集名称
     */
    private String dataSetName;

    /**
     * 分类名称
     */
    private String categoryName;

    /**
     * 函数名称
     */
    private String functionName;

    private List<ApiField> apiFields;

    private List<ApiFilter> apiFilters;

    private String jsonResponse;

    public String getDataSetName() {
        return dataSetName;
    }

    public void setDataSetName(String dataSetName) {
        this.dataSetName = dataSetName;
    }

    public List<ApiField> getApiFields() {
        return apiFields;
    }

    public void setApiFields(List<ApiField> apiFields) {
        this.apiFields = apiFields;
    }

    public List<ApiFilter> getApiFilters() {
        return apiFilters;
    }

    public void setApiFilters(List<ApiFilter> apiFilters) {
        this.apiFilters = apiFilters;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getJsonResponse() {
        return jsonResponse;
    }

    public void setJsonResponse(String jsonResponse) {
        this.jsonResponse = jsonResponse;
    }
}
