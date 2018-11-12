package com.jay.demo.design.state;

/**
 * @Author JAY
 * @Date 2018/11/12 22:22
 * @Description APP通知
 **/
public class APPNotify extends AbstractNotifyState {

    @Override
    public void sendMessage(NotifyModel notifyModel) {
        if (notifyModel.getNotifyType().equals("app")){
            System.out.println("处理发送APP的流程");
        } else {
            notifyModel.setAbstractNotifyState(new PhoneNotify());
            notifyModel.sendMessage();
        }
    }
}
