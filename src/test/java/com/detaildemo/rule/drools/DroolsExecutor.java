package com.detaildemo.rule.drools;

import com.detaildemo.rule.drools.builder.BaseRuleBuilder;
import com.detaildemo.rule.drools.fact.FactData;
import com.detaildemo.rule.drools.fact.FactModel;
import org.kie.api.KieBase;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.utils.KieHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 规则执行器
 *
 * @author hawods
 * @version 2018-08-29
 */
public class DroolsExecutor {
    private static final Logger logger = LoggerFactory.getLogger(DroolsExecutor.class);

    private StatelessKieSession kieSession;

    private DroolsExecutor(StatelessKieSession kieSession) {
        this.kieSession = kieSession;
    }

    /**
     * 对一个对象执行规则
     *
     * @param object
     * @deprecated
     */
    @Deprecated
    public void execute(FactModel object) {
        kieSession.execute(object);
    }

    /**
     * 对多个对象执行规则
     *
     * @param objects
     */
    public void execute(Iterable<FactModel> objects) {
        kieSession.execute(objects);
    }

    /**
     * 对Data对象执行规则
     *
     * @param data
     * @return
     */
    public Object execute(FactData data) {
        FactModel fact = new FactModel();
        fact.setData(data);

        kieSession.execute(fact);

        return fact.getResult();
    }

    /**
     * 构建规则执行器
     *
     * @param type
     * @param rule
     * @return
     */
    public static DroolsExecutor build(RuleType type, List<String> rule) {
        String drl = BaseRuleBuilder.build(type, rule);
        logger.debug("build drl: {}", drl);

        KieHelper helper = new KieHelper();
        helper.addContent(drl, ResourceType.DRL);
        KieBase kieBase = helper.build();
        StatelessKieSession kieSession = kieBase.newStatelessKieSession();

        return new DroolsExecutor(kieSession);
    }

    /**
     * 校验规则
     *
     * @param rule
     * @return
     */
    public static boolean verify(RuleType type, List<String> rule) {
        try {
            String drl = BaseRuleBuilder.build(type, rule);
            logger.debug("verify drl: {}", drl);

            KieHelper helper = new KieHelper();
            helper.addContent(drl, ResourceType.DRL);
            Results results = helper.verify();

            return !results.hasMessages(Message.Level.ERROR);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return false;
    }
}
