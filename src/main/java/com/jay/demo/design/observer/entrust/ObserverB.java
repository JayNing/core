package com.jay.demo.design.observer.entrust;

import com.jay.demo.design.observer.observer_.Observer;
import com.jay.demo.design.observer.observer_.Subject;

/**
 * @Author JAY
 * @Date 2018/11/11 14:43
 * @Description 员工B
 **/
public class ObserverB {

    public void orderBus(String msg) {
        System.out.println("员工B收到通知: " + msg);
    }
}
