package com.jay.demo.design.chainOfResponsibility;

/**
 * @Author JAY
 * @Date 2018/11/24 15:55
 * @Description 经理
 **/
public class JLManager extends Manager {

    public JLManager(String name) {
        super(name);
    }

    @Override
    public void processRequest(Request request) {

        if ("加薪".equals(request.getContent())){
            if (request.getCount() < 500){
                System.out.println("经理" + this.getName() + "批准给" + request.getName() + "加薪" + request.getCount() + "元");
            }else {
                //上报给总监
                if (this.getSuperManager() != null){
                    this.getSuperManager().processRequest(request);
                }
            }
        }
        
    }
}
