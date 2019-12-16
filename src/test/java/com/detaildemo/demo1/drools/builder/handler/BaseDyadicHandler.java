package com.detaildemo.demo1.drools.builder.handler;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 处理二元运算基类
 *
 * @author hawods
 * @version 2018-10-19
 */
public abstract class BaseDyadicHandler extends BaseRuleHandler {
    /**
     * 参数占位符
     */
    protected static final String VALUE_HOLDER = "${value}";

    public BaseDyadicHandler(BaseRuleHandler next) {
        super(next);
    }

    @Override
    public String handle(List<String> rule) {
        List<String> leftItems = new ArrayList<>();
        List<String> rightItems = new ArrayList<>();
        String operator = null;
        for (String item : rule) {
            if (operator != null) {
                rightItems.add(item);
            } else if (getOperatorMap().containsKey(item)) {
                operator = getOperatorMap().get(item);
            } else {
                leftItems.add(item);
            }
        }

        String result = getValue(leftItems, next);
        if (result == null) {
            throw new UnsupportedOperationException();
        }

        if (!CollectionUtils.isEmpty(rightItems)) {
            String rightValue = getValue(rightItems, this);
            if (null != operator) {
                result += operator.replace(VALUE_HOLDER, rightValue);
            }
        }
        return result;
    }

    /**
     * 获取操作符与替换表达式映射表
     *
     * @return
     */
    protected abstract Map<String, String> getOperatorMap();
}
