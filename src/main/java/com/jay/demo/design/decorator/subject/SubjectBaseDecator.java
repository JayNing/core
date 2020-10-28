package com.jay.demo.design.decorator.subject;

/**
 * ClassName: SubjectDecator
 * Description:
 * date: 2020/10/28 16:18
 *
 * @author ningjianjian
 */
public class SubjectBaseDecator extends AbstractSubject{

    private AbstractSubject subject;

    public  SubjectBaseDecator(AbstractSubject subject){
        this.subject = subject;
    }


    @Override
    protected String getName() {
        return this.subject.getName();
    }

    @Override
    protected int getPrice() {
        return this.subject.getPrice();
    }
}
