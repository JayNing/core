package com.jay.demo.design.state;

/**
 * @Author JAY
 * @Date 2018/11/12 22:21
 * @Description 通知model
 **/
public class NotifyModel {

    private String notifyType;

    private AbstractNotifyState abstractNotifyState;

    public NotifyModel(){
        //初始化为短信发送
        this.abstractNotifyState = new SMSNotify();
    }

    public AbstractNotifyState getAbstractNotifyState() {
        return abstractNotifyState;
    }

    public void setAbstractNotifyState(AbstractNotifyState abstractNotifyState) {
        this.abstractNotifyState = abstractNotifyState;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public void sendMessage(){
        abstractNotifyState.sendMessage(this);
    }

}
