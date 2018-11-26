package com.jay.demo.design.chainOfResponsibility;

/**
 * @Author JAY
 * @Date 2018/11/24 15:52
 * @Description 管理者抽象类
 **/
public abstract class Manager {

    private String name;

    public Manager(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //上级管理者
    private Manager superManager;

    //设置上级管理者
    public Manager getSuperManager() {
        return superManager;
    }

    public void setSuperManager(Manager superManager) {
        this.superManager = superManager;
    }

    /**
     * 处理请求
     * @param request
     */
    public abstract void processRequest(Request request);

}
