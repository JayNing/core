package com.detaildemo.rule.drools.builder.handler;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理乘除余
 *
 * @author hawods
 * @version 2018-10-18
 */
public class MultiplicativeHandler extends BaseDyadicHandler {
    private static final Map<String, String> OPERATOR_MAP;

    static {
        OPERATOR_MAP = new HashMap<>();
        OPERATOR_MAP.put("*", ".multiply(" + VALUE_HOLDER + ")");
        OPERATOR_MAP.put("/", ".divide(" + VALUE_HOLDER + ")");
        OPERATOR_MAP.put("%", ".remainder(" + VALUE_HOLDER + ")");
    }

    public MultiplicativeHandler(BaseRuleHandler next) {
        super(next);
    }

    @Override
    protected Map<String, String> getOperatorMap() {
        return OPERATOR_MAP;
    }
}
