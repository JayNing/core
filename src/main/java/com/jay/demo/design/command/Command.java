package com.jay.demo.design.command;

/**
 * @Author JAY
 * @Date 2018/11/21 22:36
 * @Description 抽象命令
 **/
public abstract class Command {
    //聚合一个烤羊肉串者
    private Barbecuer receiver;

    public Barbecuer getReceiver() {
        return receiver;
    }

    //只需要确定“烤肉者”是谁
    public void setReceiver(Barbecuer receiver) {
        this.receiver = receiver;
    }

    //执行命令
    public abstract void executeCommand();
}
