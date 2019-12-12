package com.detaildemo.rule.drools.builder;


import com.detaildemo.rule.drools.RuleType;

import java.util.List;

/**
 * 规则构造器
 *
 * @author hawods
 * @version 2018-08-29
 */
public abstract class BaseRuleBuilder {
    /**
     * 转换为drl
     *
     * @param rule
     * @return
     */
    public static String build(RuleType type, List<String> rule) {
        BaseRuleBuilder builder;
        switch (type) {
            case VALIDATION:
                builder = new ValidationRuleBuilder();
                break;
            case CALCULATION:
                builder = new CalculationRuleBuilder();
                break;
            default:
                builder = new ValidationRuleBuilder();
                break;
        }
        return builder.build(rule);
    }

    public String build(List<String> rule) {
        StringBuilder ruleSb = new StringBuilder();
        ruleSb.append("package com.detaildemo\n");
        ruleSb.append("import java.util.List\n");
        ruleSb.append("import java.util.Map\n");
        ruleSb.append("import com.detaildemo.rule.drools.fact.FactModel\n");
        ruleSb.append("rule \"rule\"\n");
        ruleSb.append("\twhen\n");
        ruleSb.append("\t\t$fact : FactModel($data : data, ");
        ruleSb.append(getCondition(rule));
        ruleSb.append(");\n");
        ruleSb.append("\tthen\n");
        ruleSb.append("\t\t$fact.setResult(");
        ruleSb.append(getResult(rule));
        ruleSb.append(");\n");
        ruleSb.append("end\n");

        return ruleSb.toString();
    }

    /**
     * 获取条件表达式
     *
     * @param rule
     * @return
     */
    protected abstract String getCondition(List<String> rule);

    /**
     * 获取结果表达式
     *
     * @param rule
     * @return
     */
    protected abstract String getResult(List<String> rule);

}
