package com.dynamic.code.model;



public class ApiInfo {
    /**
     * 接口名称
     */
    private String name;

    /**
     * 接口标识
     */
    private String apiCode;

    /**
     * 应用类型
     */
    private String appType;

    /**
     * 应用编码
     */
    private String appCode;

    /**
     * 所属分类
     */
    private String categoryId;

    /**
     * 所属分类编码
     */
    private String categoryCode;

    /**
     * 关联数据集id
     */
    private String dataSetId;

    /**
     * 函数id
     */
    private String functionId;

    /**
     * 是否分页（0：否；1：是）
     */
    private String isPaging;

    /**
     * 状态（0：草稿 ；1：发布；2：下线）
     */
    private String status;

    /**
     * 删除(0:正常,1:已删除)
     */
    private String isDeleted;

    /**
     * 接口版本号
     */
    private String apiVersion;

    /**
     * 接口响应格式
     */
    private String respFormat;

    /**
     * 成功响应示例
     */
    private String exampleSuccessResp;

    /**
     * 失败响应示例
     */
    private String exampleFailResp;

    /**
     * 备注
     */
    private String remark;

    /**
     * 获取接口名称
     *
     * @return name - 接口名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置接口名称
     *
     * @param name 接口名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取接口标识
     *
     * @return api_code - 接口标识
     */
    public String getApiCode() {
        return apiCode;
    }

    /**
     * 设置接口标识
     *
     * @param apiCode 接口标识
     */
    public void setApiCode(String apiCode) {
        this.apiCode = apiCode == null ? null : apiCode.trim();
    }

    /**
     * 获取应用类型
     *
     * @return app_type - 应用类型
     */
    public String getAppType() {
        return appType;
    }

    /**
     * 设置应用类型
     *
     * @param appType 应用类型
     */
    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    /**
     * 获取应用编码
     *
     * @return app_code - 应用编码
     */
    public String getAppCode() {
        return appCode;
    }

    /**
     * 设置应用编码
     *
     * @param appCode 应用编码
     */
    public void setAppCode(String appCode) {
        this.appCode = appCode == null ? null : appCode.trim();
    }

    /**
     * 获取所属分类
     *
     * @return category_id - 所属分类
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * 设置所属分类
     *
     * @param categoryId 所属分类
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    /**
     * 获取所属分类编码
     *
     * @return category_code - 所属分类编码
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * 设置所属分类编码
     *
     * @param categoryCode 所属分类编码
     */
    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    /**
     * 获取关联数据集id
     *
     * @return data_set_id - 关联数据集id
     */
    public String getDataSetId() {
        return dataSetId;
    }

    /**
     * 设置关联数据集id
     *
     * @param dataSetId 关联数据集id
     */
    public void setDataSetId(String dataSetId) {
        this.dataSetId = dataSetId == null ? null : dataSetId.trim();
    }

    /**
     * 获取函数id
     *
     * @return function_id - 函数id
     */
    public String getFunctionId() {
        return functionId;
    }

    /**
     * 设置函数id
     *
     * @param functionId 函数id
     */
    public void setFunctionId(String functionId) {
        this.functionId = functionId == null ? null : functionId.trim();
    }

    /**
     * 获取是否分页（0：否；1：是）
     *
     * @return is_paging - 是否分页（0：否；1：是）
     */
    public String getIsPaging() {
        return isPaging;
    }

    /**
     * 设置是否分页（0：否；1：是）
     *
     * @param isPaging 是否分页（0：否；1：是）
     */
    public void setIsPaging(String isPaging) {
        this.isPaging = isPaging == null ? null : isPaging.trim();
    }

    /**
     * 获取状态（0：草稿 ；1：发布；2：下线）
     *
     * @return status - 状态（0：草稿 ；1：发布；2：下线）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0：草稿 ；1：发布；2：下线）
     *
     * @param status 状态（0：草稿 ；1：发布；2：下线）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取删除(0:正常,1:已删除)
     *
     * @return is_deleted - 删除(0:正常,1:已删除)
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置删除(0:正常,1:已删除)
     *
     * @param isDeleted 删除(0:正常,1:已删除)
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted == null ? null : isDeleted.trim();
    }

    /**
     * 获取接口版本号
     *
     * @return api_version - 接口版本号
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * 设置接口版本号
     *
     * @param apiVersion 接口版本号
     */
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion == null ? null : apiVersion.trim();
    }

    /**
     * 获取接口响应格式
     *
     * @return resp_format - 接口响应格式
     */
    public String getRespFormat() {
        return respFormat;
    }

    /**
     * 设置接口响应格式
     *
     * @param respFormat 接口响应格式
     */
    public void setRespFormat(String respFormat) {
        this.respFormat = respFormat == null ? null : respFormat.trim();
    }

    /**
     * 获取成功响应示例
     *
     * @return example_success_resp - 成功响应示例
     */
    public String getExampleSuccessResp() {
        return exampleSuccessResp;
    }

    /**
     * 设置成功响应示例
     *
     * @param exampleSuccessResp 成功响应示例
     */
    public void setExampleSuccessResp(String exampleSuccessResp) {
        this.exampleSuccessResp = exampleSuccessResp == null ? null : exampleSuccessResp.trim();
    }

    /**
     * 获取失败响应示例
     *
     * @return example_fail_resp - 失败响应示例
     */
    public String getExampleFailResp() {
        return exampleFailResp;
    }

    /**
     * 设置失败响应示例
     *
     * @param exampleFailResp 失败响应示例
     */
    public void setExampleFailResp(String exampleFailResp) {
        this.exampleFailResp = exampleFailResp == null ? null : exampleFailResp.trim();
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}