package com.detaildemo.rule.drools.builder.handler;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 规则处理器
 *
 * @author hawods
 * @version 2018-10-18
 */
public abstract class BaseRuleHandler {
    protected BaseRuleHandler next;

    public BaseRuleHandler() {
    }

    public BaseRuleHandler(BaseRuleHandler next) {
        this.next = next;
    }

    /**
     * 处理规则
     *
     * @param rule
     * @return
     */
    public abstract String handle(List<String> rule);

    protected String getValue(List<String> items, BaseRuleHandler handler) {
        if (CollectionUtils.isEmpty(items)) {
            return null;
        }

        if (items.size() > 1) {
            if (handler == null) {
                throw new UnsupportedOperationException();
            }

            return handler.handle(items);
        }

        if (handler != null) {
            return handler.handle(items);
        }

        return items.get(0);
    }

}
