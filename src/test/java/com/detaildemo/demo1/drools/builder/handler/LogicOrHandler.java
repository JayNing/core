package com.detaildemo.demo1.drools.builder.handler;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理逻辑或
 *
 * @author hawods
 * @version 2018-10-19
 */
public class LogicOrHandler extends BaseDyadicHandler {
    private static final Map<String, String> OPERATOR_MAP;

    static {
        OPERATOR_MAP = new HashMap<>();
        OPERATOR_MAP.put("||", " || " + VALUE_HOLDER);
    }

    public LogicOrHandler(BaseRuleHandler next) {
        super(next);
    }

    @Override
    protected Map<String, String> getOperatorMap() {
        return OPERATOR_MAP;
    }
}
