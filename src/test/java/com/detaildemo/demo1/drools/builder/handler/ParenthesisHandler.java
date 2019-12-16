package com.detaildemo.demo1.drools.builder.handler;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 处理小括号
 *
 * @author hawods
 * @version 2018-10-19
 */
public class ParenthesisHandler extends BaseRuleHandler {

    public ParenthesisHandler(BaseRuleHandler next) {
        super(next);
    }

    @Override
    public String handle(List<String> rule) {
        Stack<String> items = new Stack<>();
        for (String item : rule) {
            if (")".equals(item)) {
                List<String> subRule = new ArrayList<>();
                while (true) {
                    if (items.empty()) {
                        throw new UnsupportedOperationException();
                    }

                    String i = items.pop();
                    if ("(".equals(i)) {
                        if (CollectionUtils.isEmpty(subRule)) {
                            throw new UnsupportedOperationException();
                        }

                        items.push("(" + next.handle(subRule) + ")");
                        break;
                    } else {
                        subRule.add(0, i);
                    }
                }
            } else {
                items.push(item);
            }
        }
        return next.handle(items);
    }
}
