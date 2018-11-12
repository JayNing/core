package com.jay.demo.design.state;

/**
 * @Author JAY
 * @Date 2018/11/12 22:18
 * @Description 抽象发送消息方式，即抽象状态类
 **/
public abstract class AbstractNotifyState {

    public abstract void sendMessage(NotifyModel notifyModel);

}
