package com.jay.demo.gupao.thread;

import java.util.concurrent.*;

/**
 * @Author JAY
 * @Date 2019/7/10 20:03
 * @Description 多线程模拟同步发送多种通道消息的测试
 **/
public class MessageThreadTest {

    public static void main(String[] args) {
        MessageFacade messageFacade = new MessageFacade();
        long startTime = System.currentTimeMillis();
        System.out.println("任务开始时间: " + startTime);
        //假如要发送100条消息
        for (int i = 1; i <= 100; i++){
            int finalI = i;
            new Thread(() -> {
                messageFacade.sendMessage("消息编号：" + finalI);
            }).start();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("任务结束时间: " + endTime);
        System.out.println("任务耗时: " + (endTime - startTime) + "毫秒");
    }

}
