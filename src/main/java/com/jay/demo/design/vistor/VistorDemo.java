package com.jay.demo.design.vistor;

/**
 * @Author JAY
 * @Date 2018/11/25 16:39
 * @Description 访问者模式demo
 **/
public class VistorDemo {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();
        objectStructure.add(new Man());
        objectStructure.add(new Wemon());
        Action action1 = new Success();
        objectStructure.display(action1);
        System.out.println("--------------------------------");
        Action action2 = new Marriage();
        objectStructure.display(action2);
        /**
         * 使用访问者模式，可以任意添加新的状态
         */
    }
}
