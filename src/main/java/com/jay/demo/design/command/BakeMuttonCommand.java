package com.jay.demo.design.command;

/**
 * @Author JAY
 * @Date 2018/11/21 22:39
 * @Description 具体的烤羊肉串命令
 **/
public class BakeMuttonCommand extends Command {

    public BakeMuttonCommand(Barbecuer receiver){
        this.setReceiver(receiver);
    }

    @Override
    public void executeCommand() {
        //执行命令时，执行具体的行为
        this.getReceiver().bakeMutton();
    }
}
