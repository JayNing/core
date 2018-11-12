package com.jay.demo.design.state;

/**
 * @Author JAY
 * @Date 2018/11/12 22:27
 * @Description 状态模式demo
 **/
public class StateMainDemo {

    public static void main(String[] args) {
        NotifyModel notifyModel = new NotifyModel();
        notifyModel.setNotifyType("phone");
        notifyModel.sendMessage();
    }

}
