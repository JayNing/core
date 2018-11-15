package com.jay.demo.design.memento;

/**
 * @Author JAY
 * @Date 2018/11/15 22:33
 * @Description 备忘录模式demo
 **/
public class MementoDemo {

    public static void main(String[] args) {
        GameRole gameRole = new GameRole();
        System.out.println("角色初始状态：" + gameRole);
        //备份
        RoleMemento roleMemento = gameRole.backupRoleState();
        RoleStateCareTaker roleStateCareTaker = new RoleStateCareTaker();
        roleStateCareTaker.setRoleMemento(roleMemento);
        System.out.println("开始打Boss......");
        gameRole.attackBoss();
        System.out.println("攻击完Boss后的角色状态：" + gameRole);
        //还原
        gameRole.callbackRoleState(roleStateCareTaker.getRoleMemento());
        System.out.println("还原后的角色状态：" + gameRole);
    }

}
