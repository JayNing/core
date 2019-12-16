package com.detaildemo.demo1.drools.builder.handler;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理加减运算
 *
 * @author hawods
 * @version 2018-10-18
 */
public class AdditiveHandler extends BaseDyadicHandler {
    private static final Map<String, String> OPERATOR_MAP;

    static {
        OPERATOR_MAP = new HashMap<>();
        OPERATOR_MAP.put("+", ".add(" + VALUE_HOLDER + ")");
        OPERATOR_MAP.put("-", ".subtract(" + VALUE_HOLDER + ")");
    }

    public AdditiveHandler(BaseRuleHandler next) {
        super(next);
    }

    @Override
    protected Map<String, String> getOperatorMap() {
        return OPERATOR_MAP;
    }

}
