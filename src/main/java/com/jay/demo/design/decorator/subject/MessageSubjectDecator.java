package com.jay.demo.design.decorator.subject;

import com.util.StringUtils;

/**
 * ClassName: MessageSubjectDecator
 * Description:
 * date: 2020/10/28 16:21
 *
 * @author ningjianjian
 */
public class MessageSubjectDecator extends AbstractSubject{

    private AbstractSubject subject;

    public MessageSubjectDecator(AbstractSubject subject){
        this.subject = subject;
    }

    @Override
    protected String getName() {
        if (StringUtils.isEmpty(this.subject.getName())){
            return "留言板主题";
        } else {
            return this.subject.getName() + ", 留言板主题";
        }
    }

    @Override
    protected int getPrice() {
        return this.subject.getPrice() + 10;
    }
}
