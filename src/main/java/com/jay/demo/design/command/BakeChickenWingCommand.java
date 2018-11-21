package com.jay.demo.design.command;

/**
 * @Author JAY
 * @Date 2018/11/21 22:39
 * @Description 具体的烤鸡翅命令
 **/
public class BakeChickenWingCommand extends Command {

    public BakeChickenWingCommand(Barbecuer receiver){
        this.setReceiver(receiver);
    }

    @Override
    public void executeCommand() {
        //执行命令时，执行具体的行为
        this.getReceiver().bakeChickenWing();
    }
}
