package com.jay.demo.design.state;

/**
 * @Author JAY
 * @Date 2018/11/12 22:22
 * @Description APP通知
 **/
public class PhoneNotify extends AbstractNotifyState {

    @Override
    public void sendMessage(NotifyModel notifyModel) {
        if (notifyModel.getNotifyType().equals("phone")){
            System.out.println("处理发送Phone的流程");
        } else {
            System.out.println("未知的发送消息方式");
        }
    }
}
