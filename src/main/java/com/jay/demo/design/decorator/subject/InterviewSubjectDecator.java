package com.jay.demo.design.decorator.subject;

import com.util.StringUtils;

/**
 * ClassName: MessageSubjectDecator
 * Description:
 * date: 2020/10/28 16:21
 *
 * @author ningjianjian
 */
public class InterviewSubjectDecator extends AbstractSubject{

    private AbstractSubject subject;

    public InterviewSubjectDecator(AbstractSubject subject){
        this.subject = subject;
    }

    @Override
    protected String getName() {
        if (StringUtils.isEmpty(this.subject.getName())){
            return "面试主题";
        } else {
            return this.subject.getName() + ", 面试主题";
        }
    }

    @Override
    protected int getPrice() {
        return this.subject.getPrice() + 20;
    }
}
