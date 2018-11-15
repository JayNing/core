package com.jay.demo.design.memento;

/**
 * @Author JAY
 * @Date 2018/11/15 22:25
 * @Description 游戏角色
 **/
public class GameRole {

    private int lifeValue = 100; //生命值

    private int attackValue = 100;//攻击值

    private int defenseValue = 100; //防御值

    public RoleMemento backupRoleState(){
        return new RoleMemento(lifeValue,attackValue,defenseValue);
    }

    public void callbackRoleState (RoleMemento roleMemento){
        this.lifeValue = roleMemento.getLifeValue();
        this.attackValue = roleMemento.getAttackValue();
        this.defenseValue = roleMemento.getDefenseValue();
    }

    public void attackBoss(){
        this.lifeValue = 10;
        this.attackValue = 100;
        this.defenseValue = 50;
    }

    @Override
    public String toString() {
        return "GameRole{" +
                "lifeValue=" + lifeValue +
                ", attackValue=" + attackValue +
                ", defenseValue=" + defenseValue +
                '}';
    }
}
