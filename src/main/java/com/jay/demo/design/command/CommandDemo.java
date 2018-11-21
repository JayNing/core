package com.jay.demo.design.command;

/**
 * @Author JAY
 * @Date 2018/11/21 22:44
 * @Description 命令模式
 **/
public class CommandDemo {
    public static void main(String[] args) {
        /**
         * 顾客1，下单烤羊肉串和烤鸡翅
         */
        Barbecuer receiver1 = new Barbecuer();
        Command muttonCommand = new BakeMuttonCommand(receiver1);
        Command chickenWingCommand = new BakeChickenWingCommand(receiver1);
        //将命令通知服务员，然后由服务员通知厨师。但是服务员1的业务不熟练，她是每来一个指令，都会通知厨师一次
        Waiter1 waiter1 = new Waiter1();
        waiter1.setCommand(muttonCommand);
        waiter1.notifyCooker();
        waiter1.setCommand(chickenWingCommand);
        waiter1.notifyCooker();
        System.out.println("===================================================");
        /**
         * 因为服务员1的业务不熟练，被开除了，所以招了个新的服务员2。
         * 服务员2可以接收下单后，一次性通知厨师，还可撤销订单；当厨房鸡翅没有了后，可会通知顾客，鸡翅没有了
         */
        Waiter2 waiter2 = new Waiter2();
        waiter2.setOrder(muttonCommand);
        waiter2.setOrder(chickenWingCommand);
        //顾客要多加几串烤羊肉串，又来了个命令
        Command muttonCommand2 = new BakeMuttonCommand(receiver1);
        waiter2.setOrder(muttonCommand2);
        //服务员一次性通知厨师
        waiter2.notifyCooker();
        System.out.println("--------------------------------------");
        /**
         * 使用抽象命令的好处，就是当顾客有了新类型请求后，比如“要一个汉堡”，
         * 可以通过添加一个具体的HamburgerCommand，实现功能
         */
        Command hamburgerCommand = new HamburgerCommand(receiver1);
        waiter2.setOrder(hamburgerCommand);
        waiter2.notifyCooker();
        System.out.println("+++++++++++++++++++++++++++++++++++");
        //撤销一次烤羊肉串命令
        waiter2.removeOrder(muttonCommand2);
        waiter2.notifyCooker();
    }

}
