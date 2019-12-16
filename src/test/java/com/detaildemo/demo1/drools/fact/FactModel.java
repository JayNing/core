package com.detaildemo.demo1.drools.fact;

/**
 * 规则执行对象
 *
 * @author hawods
 * @version 2018-08-29
 */
public class FactModel {
    public static final String MATCHED = "1";

    /**
     * 数据
     */
    private FactData data;
    /**
     * 匹配状态，大于0则表示规则匹配
     */
    private Object result;

    public FactData getData() {
        return data;
    }

    public void setData(FactData data) {
        this.data = data;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isMatched() {
        return MATCHED.equals(result);
    }
}
