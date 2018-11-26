package com.jay.demo.design.chainOfResponsibility;

/**
 * @Author JAY
 * @Date 2018/11/24 16:04
 * @Description 职责链模式demo
 **/
public class ResponsibilityDemo {

   public static void main(String[] args) {
       Request request1 = new Request("张三","加薪", 100);
       Request request2 = new Request("李四","加薪", 700);
       Request request3 = new Request("王五","加薪", 1700);
       Request request4 = new Request("陈六","加薪", 3000);

       JLManager jlManager = new JLManager("景丽");
       ZJManager zjManager = new ZJManager("倧剑");
       ZJLManager zjlManager = new ZJLManager("宗经理");
       jlManager.setSuperManager(zjManager);
       zjManager.setSuperManager(zjlManager);

       System.out.println("------------------------------------");
       jlManager.processRequest(request1);
       System.out.println("------------------------------------");
       jlManager.processRequest(request2);
       System.out.println("------------------------------------");
       jlManager.processRequest(request3);
       System.out.println("------------------------------------");
       jlManager.processRequest(request4);
   }


}
