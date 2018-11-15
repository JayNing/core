package com.jay.demo.design.memento;

/**
 * @Author JAY
 * @Date 2018/11/15 22:29
 * @Description 角色状态管理器
 **/
public class RoleStateCareTaker {

    private RoleMemento roleMemento;

    public RoleMemento getRoleMemento() {
        return roleMemento;
    }

    public void setRoleMemento(RoleMemento roleMemento) {
        this.roleMemento = roleMemento;
    }
}
