package com.detaildemo.demo1.drools.builder;

import com.detaildemo.demo1.drools.builder.handler.*;

import java.util.List;

/**
 * 校验DRL构造器
 *
 * @author hawods
 * @version 2018-08-31
 */
public class ValidationRuleBuilder extends BaseRuleBuilder {
    @Override
    protected String getCondition(List<String> rule) {
        BaseRuleHandler handler = new DataHandler();
        handler = new MethodHandler(handler);
        handler = new MultiplicativeHandler(handler);
        handler = new AdditiveHandler(handler);
        handler = new RelationalHandler(handler);
        handler = new LogicAndHandler(handler);
        handler = new LogicOrHandler(handler);
        handler = new ParenthesisHandler(handler);

        return handler.handle(rule);
    }

    @Override
    protected String getResult(List<String> rule) {
        return "FactModel.MATCHED";
    }
}
