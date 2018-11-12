package com.jay.demo.design.state;

/**
 * @Author JAY
 * @Date 2018/11/12 22:22
 * @Description 短信通知
 **/
public class SMSNotify extends AbstractNotifyState {
    @Override
    public void sendMessage(NotifyModel notifyModel) {
        if (notifyModel.getNotifyType().equals("sms")){
            System.out.println("处理发送短信的流程");
        } else {
          notifyModel.setAbstractNotifyState(new EmailNotify());
          notifyModel.sendMessage();
        }
    }
}
