package com.detaildemo.rule.drools.builder;


import com.detaildemo.rule.drools.builder.handler.*;

import java.util.List;

/**
 * 计算DRL构造器
 *
 * @author hawods
 * @version 2018-08-31
 */
public class CalculationRuleBuilder extends BaseRuleBuilder {
    @Override
    protected String getCondition(List<String> rule) {
        return "eval(true)";
    }

    @Override
    protected String getResult(List<String> rule) {
        BaseRuleHandler handler = new DataHandler();
        handler = new MultiplicativeHandler(handler);
        handler = new AdditiveHandler(handler);
        handler = new ParenthesisHandler(handler);

        return handler.handle(rule) + ".toString()";
    }
}

