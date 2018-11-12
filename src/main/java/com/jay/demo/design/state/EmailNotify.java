package com.jay.demo.design.state;

/**
 * @Author JAY
 * @Date 2018/11/12 22:21
 * @Description 邮件通知
 **/
public class EmailNotify extends AbstractNotifyState {
    @Override
    public void sendMessage(NotifyModel notifyModel) {
        if (notifyModel.getNotifyType().equals("email")){
            System.out.println("处理发送邮件的流程");
        } else {
            notifyModel.setAbstractNotifyState(new APPNotify());
            notifyModel.sendMessage();
        }
    }
}
