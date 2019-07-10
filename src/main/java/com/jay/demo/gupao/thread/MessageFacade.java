package com.jay.demo.gupao.thread;

/**
 * @Author JAY
 * @Date 2019/7/10 20:01
 * @Description 模拟消息中心发送消息接口
 **/
public class MessageFacade {

    public void sendMessage(String msg){
        try {
            System.out.println("msg :" + msg);
            //模拟发送消息每条用时500毫秒钟
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
