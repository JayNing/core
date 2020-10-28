package com.jay.demo.design.decorator.subject;

/**
 * ClassName: BaseSubject
 * Description:
 * date: 2020/10/28 16:17
 *
 * @author ningjianjian
 */
public class BaseSubject extends AbstractSubject {

    @Override
    protected String getName() {
        return "基础主题";
    }

    @Override
    protected int getPrice() {
        return 10;
    }
}
