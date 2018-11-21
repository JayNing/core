package com.jay.demo.design.command;

/**
 * @Author JAY
 * @Date 2018/11/21 22:42
 * @Description 服务员1
 **/
public class Waiter1 {

    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    //通知厨师
    public void notifyCooker(){
        command.executeCommand();
    }
}
