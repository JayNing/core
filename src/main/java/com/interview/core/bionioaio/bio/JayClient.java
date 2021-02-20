package com.interview.core.bionioaio.bio;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * ClassName: JayClient
 * Description:
 * date: 2021/2/20 12:45
 *
 * @author ningjianjian
 */
public class JayClient {
    public static void main(String[] args) {
        // TODO 创建多个线程，模拟多个客户端连接服务端
        new Thread(() -> {
            while (true) {
                Socket socket = null;
                try {
                    socket = new Socket("127.0.0.1", 1234);
                    socket.getOutputStream().write(("你好啊," + new Date()).getBytes("UTF-8"));
                    Thread.sleep(1000L);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
