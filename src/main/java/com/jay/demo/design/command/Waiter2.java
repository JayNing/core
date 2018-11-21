package com.jay.demo.design.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JAY
 * @Date 2018/11/21 22:42
 * @Description 服务员1
 **/
public class Waiter2 {

    private List<Command> commandList;

    //下单
    public void setOrder(Command command){
        //可以记录日志
        if (commandList == null){
            commandList = new ArrayList<>();
        }
        if (command instanceof BakeChickenWingCommand){
            //如果下的是烤鸡翅，通知顾客，鸡翅没有了
            System.out.println("不好意思，鸡翅没有了");
        }else {
            commandList.add(command);
        }
    }

    //撤销订单
    public void removeOrder(Command command){
        commandList.remove(command);
        //可以记录日志
    }

    //通知厨师
    public void notifyCooker(){
        //一次性通知
        for (Command command : commandList) {
            command.executeCommand();
        }
    }
}
