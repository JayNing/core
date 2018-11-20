package com.jay.demo.design.bridge;

/**
 * @Author JAY
 * @Date 2018/11/20 21:44
 * @Description 桥接模式demo
 **/
public class BridgeDemo {

    public static void main(String[] args) {
        System.out.println("先添加A品牌手机，添加A软件功能");
        AbstractPhone phoneA = new PhoneA();
        phoneA.addSoft(new SoftA());
        phoneA.run();

        System.out.println("再给A品牌手机，添加B软件功能");
        phoneA.addSoft(new SoftB());
        phoneA.run();

        System.out.println("再添加个新品牌手机B，添加A软件功能");
        AbstractPhone phoneB = new PhoneB();
        phoneB.addSoft(new SoftA());
        phoneB.run();
    }

}
