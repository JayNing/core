package com.detaildemo.demo1.drools.builder.handler;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 处理数据
 *
 * @author hawods
 * @version 2018-10-18
 */
public class DataHandler extends BaseRuleHandler {
    private static final Pattern TEXT_PATTERN = Pattern.compile("^\"[^$]*\"$");
    private static final Pattern DATA_PATTERN = Pattern.compile("^\\$\\(\"[\\w\\s-\\.]*\"\\)$");

    @Override
    public String handle(List<String> rule) {
        if (rule.size() != 1) {
            throw new UnsupportedOperationException();
        }

        String item = rule.get(0);
        if (TEXT_PATTERN.matcher(item).find()) {
            return "$data.toValue(" + item + ")";
        }
        if (DATA_PATTERN.matcher(item).find()) {
            return "$data.get" + item.substring(1);
        }

        return item;
    }
}
