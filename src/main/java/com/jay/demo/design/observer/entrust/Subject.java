package com.jay.demo.design.observer.entrust;

import com.jay.demo.design.observer.observer_.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JAY
 * @Date 2018/11/11 14:37
 * @Description 主题，抽象通知者
 **/
public abstract class Subject {

    private EventHandler eventHandler = new EventHandler();

    public EventHandler getEventHandler() {
        return eventHandler;
    }

    public void setEventHandler(EventHandler eventHandler) {
        this.eventHandler = eventHandler;
    }

    public abstract void addObserver(Object object,String methodName, Object...args);

    //发送通知
    public abstract void notifyNewInfo();

}
