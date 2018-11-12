package com.jay.demo.design.observer.observer_;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JAY
 * @Date 2018/11/11 14:37
 * @Description 主题，抽象通知者
 **/
public abstract class Subject {

    private String notifyInfo;

    private List<Observer> observerList = new ArrayList<>();

    public String getNotifyInfo() {
        return notifyInfo;
    }

    public void setNotifyInfo(String notifyInfo) {
        this.notifyInfo = notifyInfo;
    }

    //新来的员工，添加到观察者集合中
    public void addObserver(Observer observer){
        observerList.add(observer);
    }
    //离职的员工，从观察者集合中移除
    public void removeObserver(Observer observer){
        observerList.remove(observer);
    }

    //发送通知
    public void notifyNewInfo(){
        for (Observer observer : observerList) {
            observer.update();
        }
    }

}
