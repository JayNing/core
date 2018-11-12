package com.jay.demo.design.observer.entrust;

import com.jay.demo.design.observer.observer_.Observer;
import com.jay.demo.design.observer.observer_.Subject;

/**
 * @Author JAY
 * @Date 2018/11/11 14:43
 * @Description 员工A
 **/
public class ObserverA {

    public void food(String msg) {
        System.out.println("员工A收到通知: " + msg);
    }

}
