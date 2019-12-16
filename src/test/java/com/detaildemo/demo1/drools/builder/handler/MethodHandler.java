package com.detaildemo.demo1.drools.builder.handler;

import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * 处理自定义方法
 *
 * @author hawods
 * @version 2018-10-19
 */
public class MethodHandler extends BaseRuleHandler {
    public MethodHandler(BaseRuleHandler next) {
        super(next);
    }

    @Override
    public String handle(List<String> rule) {
        if (CollectionUtils.isEmpty(rule) || rule.size() > 2 ) {
            throw new UnsupportedOperationException();
        }

        String result = next.handle(Collections.singletonList(rule.get(0)));
        if (rule.size() == 2) {
            String method = rule.get(1);
            if (!method.startsWith("$")) {
                throw new UnsupportedOperationException();
            }

            result += method.replaceFirst("^\\$", ".");
        }

        return result;
    }
}
