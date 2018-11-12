package com.jay.demo.design.observer.entrust;

/**
 * @Author JAY
 * @Date 2018/11/11 14:47
 * @Description 人事部经理作为通知者
 **/
public class HRSubject extends Subject {
    @Override
    public void addObserver(Object object, String methodName, Object... args) {
        this.getEventHandler().addEvent(object, methodName, args);
    }

    @Override
    public void notifyNewInfo() {
        try {
            this.getEventHandler().notifyX();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
