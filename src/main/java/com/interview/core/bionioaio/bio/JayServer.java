package com.interview.core.bionioaio.bio;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ClassName: JayServer
 * Description:
 * date: 2021/2/20 12:45
 *
 * @author ningjianjian
 */
public class JayServer {

    public static void main(String[] args) throws IOException {

        // TODO 服务端处理客户端连接请求
        ServerSocket serverSocket = new ServerSocket(1234);

        // 接收到客户端连接请求之后为每个客户端创建一个新的线程进行链路处理
        new Thread(() -> {
            while (true) {
                try {
                    // 阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();
                    // 每一个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        try {
                            int len;
                            InputStream inputStream = socket.getInputStream();
                            byte[] buffer = new byte[1024];
                            // 按字节流方式读取数据
                            while ((len = inputStream.read(buffer)) != -1){
                                System.out.println(new String(buffer, 0, len));
                            }
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        }).start();
    }

}
