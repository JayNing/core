package com.jay.demo.design.observer.entrust;

import com.jay.demo.design.observer.observer_.Observer;
import com.jay.demo.design.observer.observer_.Subject;

/**
 * @Author JAY
 * @Date 2018/11/11 14:43
 * @Description 员工C
 **/
public class ObserverC{

    public void game(String msg) {
        System.out.println("员工C收到通知: " + msg);
    }

}
