package com.jay.demo.design.observer.entrust;

/**
 * @Author JAY
 * @Date 2018/11/11 14:49
 * @Description 委托事件Demo
 **/
public class ObserverDemo {

    public static void main(String[] args) {
        //首先人事经理通知大家第一件事
        HRSubject hrSubject = new HRSubject();
        //通知三个Object监听器,并不知道具体是谁
        hrSubject.addObserver(new ObserverA(),"food","需要准备食物");
        hrSubject.addObserver(new ObserverB(),"orderBus","需要预定大巴车");
        hrSubject.addObserver(new ObserverC(),"game","准备游戏活动");
        //通知
        hrSubject.notifyNewInfo();

        hrSubject.notifyNewInfo();
    }

}
