package com.jay.demo.design.memento;

/**
 * @Author JAY
 * @Date 2018/11/15 22:27
 * @Description 角色备忘录
 **/
public class RoleMemento {

    private int lifeValue; //生命值

    private int attackValue;//攻击值

    private int defenseValue; //防御值

    public RoleMemento(int lifeValue, int attackValue, int defenseValue){
        this.lifeValue = lifeValue;
        this.attackValue = attackValue;
        this.defenseValue = defenseValue;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int lifeValue) {
        this.lifeValue = lifeValue;
    }

    public int getAttackValue() {
        return attackValue;
    }

    public void setAttackValue(int attackValue) {
        this.attackValue = attackValue;
    }

    public int getDefenseValue() {
        return defenseValue;
    }

    public void setDefenseValue(int defenseValue) {
        this.defenseValue = defenseValue;
    }
}
