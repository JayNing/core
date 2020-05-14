package com.dynamic.code.model;


public class ApiField {
    /**
     * 所属接口
     */
    private String apiId;

    /**
     * 字段属性（绑定字段）
     */
    private String field;

    /**
     * 返回列名（响应参数名）
     */
    private String fieldResponseName;

    private String fieldTableCode;

    public String getFieldTableCode() {
        return fieldTableCode;
    }

    public void setFieldTableCode(String fieldTableCode) {
        this.fieldTableCode = fieldTableCode;
    }

    /**
     * 返回参数描述
     */
    private String fieldDesc;

    /**
     * 字段类型
     */
    private String fieldType;

    /**
     * 显示格式
     */
    private String fieldFormat;

    /**
     * 返回默认值
     */
    private String defaultValue;

    /**
     * 是否返回(0:不返回，1:返回)
     */
    private String isShow;

    /**
     * 排序
     */
    private Integer fieldSort;

    /**
     * 示例值
     */
    private String exampleValue;

    private String modelPropType;

    public String getModelPropType() {
        return modelPropType;
    }

    public void setModelPropType(String modelPropType) {
        this.modelPropType = modelPropType;
    }

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
     * 获取字段属性（绑定字段）
     *
     * @return field - 字段属性（绑定字段）
     */
    public String getField() {
        return field;
    }

    /**
     * 设置字段属性（绑定字段）
     *
     * @param field 字段属性（绑定字段）
     */
    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    /**
     * 获取返回列名（响应参数名）
     *
     * @return field_response_name - 返回列名（响应参数名）
     */
    public String getFieldResponseName() {
        return fieldResponseName;
    }

    /**
     * 设置返回列名（响应参数名）
     *
     * @param fieldResponseName 返回列名（响应参数名）
     */
    public void setFieldResponseName(String fieldResponseName) {
        this.fieldResponseName = fieldResponseName == null ? null : fieldResponseName.trim();
    }

    /**
     * 获取返回参数描述
     *
     * @return field_desc - 返回参数描述
     */
    public String getFieldDesc() {
        return fieldDesc;
    }

    /**
     * 设置返回参数描述
     *
     * @param fieldDesc 返回参数描述
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
     * 获取显示格式
     *
     * @return field_format - 显示格式
     */
    public String getFieldFormat() {
        return fieldFormat;
    }

    /**
     * 设置显示格式
     *
     * @param fieldFormat 显示格式
     */
    public void setFieldFormat(String fieldFormat) {
        this.fieldFormat = fieldFormat == null ? null : fieldFormat.trim();
    }

    /**
     * 获取返回默认值
     *
     * @return default_value - 返回默认值
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 设置返回默认值
     *
     * @param defaultValue 返回默认值
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue == null ? null : defaultValue.trim();
    }

    /**
     * 获取是否返回(0:不返回，1:返回)
     *
     * @return is_show - 是否返回(0:不返回，1:返回)
     */
    public String getIsShow() {
        return isShow;
    }

    /**
     * 设置是否返回(0:不返回，1:返回)
     *
     * @param isShow 是否返回(0:不返回，1:返回)
     */
    public void setIsShow(String isShow) {
        this.isShow = isShow == null ? null : isShow.trim();
    }

    /**
     * 获取排序
     *
     * @return field_sort - 排序
     */
    public Integer getFieldSort() {
        return fieldSort;
    }

    /**
     * 设置排序
     *
     * @param fieldSort 排序
     */
    public void setFieldSort(Integer fieldSort) {
        this.fieldSort = fieldSort;
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
}