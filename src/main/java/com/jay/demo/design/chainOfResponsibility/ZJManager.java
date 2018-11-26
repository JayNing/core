package com.jay.demo.design.chainOfResponsibility;

/**
 * @Author JAY
 * @Date 2018/11/24 15:55
 * @Description 总监
 **/
public class ZJManager extends Manager {

    public ZJManager(String name) {
        super(name);
    }

    @Override
    public void processRequest(Request request) {
        if ("加薪".equals(request.getContent())){
            if (500 <= request.getCount() && request.getCount() < 1000){
                System.out.println("总监" + this.getName() + "批准给" + request.getName() + "加薪" + request.getCount() + "元");
            }else {
                //上报给总监
                if (this.getSuperManager() != null){
                    this.getSuperManager().processRequest(request);
                }
            }
        }
    }
}
