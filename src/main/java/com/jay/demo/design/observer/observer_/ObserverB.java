package com.jay.demo.design.observer.observer_;

/**
 * @Author JAY
 * @Date 2018/11/11 14:43
 * @Description 员工B
 **/
public class ObserverB extends Observer{

    private Subject subject;

    public ObserverB(Subject subject){
        this.subject = subject;
    }

    @Override
    public void update() {
        System.out.println("员工B收到通知: " + this.subject.getNotifyInfo());
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
