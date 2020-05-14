package com.dynamic.code.model;


public class ApiFilter  {
    /**
     * 所属接口
     */
    private String apiId;

    /**
     * 字段属性
     */
    private String field;

    /**
     * 字段名称
     */
    private String fieldName;

    /**
     * 请求参数名
     */
    private String fieldRequestName;

    /**
     * 请求参数描述
     */
    private String fieldDesc;

    /**
     * 字段类型
     */
    private String fieldType;

    /**
     * 业务类型（预留）
     */
    private String fieldBusinessType;

    /**
     * 操作符号
     */
    private String filterOperation;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 是否必传（0：否；1：是）
     */
    private String isRequired;

    /**
     * 示例值
     */
    private String exampleValue;

    /**
     * 参数来源（0：字段；1：变量）
     */
    private  String fieldFrom;

    /**
     * 获取所属接口
     *
     * @return api_id - 所属接口
     */
    public String getApiId() {
        return apiId;
    }

    /**
     * 设置所属接口
     *
     * @param apiId 所属接口
     */
    public void setApiId(String apiId) {
        this.apiId = apiId == null ? null : apiId.trim();
    }

    /**
     * 获取字段属性
     *
     * @return field - 字段属性
     */
    public String getField() {
        return field;
    }

    /**
     * 设置字段属性
     *
     * @param field 字段属性
     */
    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    /**
     * 获取字段名称
     *
     * @return field_name - 字段名称
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * 设置字段名称
     *
     * @param fieldName 字段名称
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName == null ? null : fieldName.trim();
    }

    /**
     * 获取请求参数名
     *
     * @return field_request_name - 请求参数名
     */
    public String getFieldRequestName() {
        return fieldRequestName;
    }

    /**
     * 设置请求参数名
     *
     * @param fieldRequestName 请求参数名
     */
    public void setFieldRequestName(String fieldRequestName) {
        this.fieldRequestName = fieldRequestName == null ? null : fieldRequestName.trim();
    }

    /**
     * 获取请求参数描述
     *
     * @return field_desc - 请求参数描述
     */
    public String getFieldDesc() {
        return fieldDesc;
    }

    /**
     * 设置请求参数描述
     *
     * @param fieldDesc 请求参数描述
     */
    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc == null ? null : fieldDesc.trim();
    }

    /**
     * 获取字段类型
     *
     * @return field_type - 字段类型
     */
    public String getFieldType() {
        return fieldType;
    }

    /**
     * 设置字段类型
     *
     * @param fieldType 字段类型
     */
    public void setFieldType(String fieldType) {
        this.fieldType = fieldType == null ? null : fieldType.trim();
    }

    /**
     * 获取业务类型（预留）
     *
     * @return field_business_type - 业务类型（预留）
     */
    public String getFieldBusinessType() {
        return fieldBusinessType;
    }

    /**
     * 设置业务类型（预留）
     *
     * @param fieldBusinessType 业务类型（预留）
     */
    public void setFieldBusinessType(String fieldBusinessType) {
        this.fieldBusinessType = fieldBusinessType == null ? null : fieldBusinessType.trim();
    }

    /**
     * 获取操作符号
     *
     * @return filter_operation - 操作符号
     */
    public String getFilterOperation() {
        return filterOperation;
    }

    /**
     * 设置操作符号
     *
     * @param filterOperation 操作符号
     */
    public void setFilterOperation(String filterOperation) {
        this.filterOperation = filterOperation == null ? null : filterOperation.trim();
    }

    /**
     * 获取默认值
     *
     * @return default_value - 默认值
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 设置默认值
     *
     * @param defaultValue 默认值
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    /**
     * 获取是否必传（0：否；1：是）
     *
     * @return is_required - 是否必传（0：否；1：是）
     */
    public String getIsRequired() {
        return isRequired;
    }

    /**
     * 设置是否必传（0：否；1：是）
     *
     * @param isRequired 是否必传（0：否；1：是）
     */
    public void setIsRequired(String isRequired) {
        this.isRequired = isRequired == null ? null : isRequired.trim();
    }

    /**
     * 获取示例值
     *
     * @return example_value - 示例值
     */
    public String getExampleValue() {
        return exampleValue;
    }

    /**
     * 设置示例值
     *
     * @param exampleValue 示例值
     */
    public void setExampleValue(String exampleValue) {
        this.exampleValue = exampleValue == null ? null : exampleValue.trim();
    }

    public String getFieldFrom() {
        return fieldFrom;
    }

    public void setFieldFrom(String fieldFrom) {
        this.fieldFrom = fieldFrom;
    }
}