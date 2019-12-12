package com.detaildemo.rule.drools.builder.handler;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理比较符
 *
 * @author hawods
 * @version 2018-10-19
 */
public class RelationalHandler extends BaseDyadicHandler {
    private static final Map<String, String> OPERATOR_MAP;

    static {
        OPERATOR_MAP = new HashMap<>();
        OPERATOR_MAP.put("==", ".eq(" + VALUE_HOLDER + ")");
        OPERATOR_MAP.put("!=", ".ne(" + VALUE_HOLDER + ")");
        OPERATOR_MAP.put("<", ".lt(" + VALUE_HOLDER + ")");
        OPERATOR_MAP.put("<=", ".le(" + VALUE_HOLDER + ")");
        OPERATOR_MAP.put(">", ".gt(" + VALUE_HOLDER + ")");
        OPERATOR_MAP.put(">=", ".ge(" + VALUE_HOLDER + ")");
        OPERATOR_MAP.put("like", ".contains(" + VALUE_HOLDER + ")");
    }

    public RelationalHandler(BaseRuleHandler next) {
        super(next);
    }

    @Override
    protected Map<String, String> getOperatorMap() {
        return OPERATOR_MAP;
    }
}
