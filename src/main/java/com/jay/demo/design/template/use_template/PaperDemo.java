package com.jay.demo.design.template.use_template;

/**
 * @Author JAY
 * @Date 2018/11/9 10:50
 * @Description 考试测试
 **/
public class PaperDemo {

   public static void main(String[] args) {
       TestPaper testPaperC = new StudentC();
       TestPaper testPaperD = new StudentC();
       System.out.println("学生C的试卷------------");
       testPaperC.question1();
       testPaperC.question2();
       testPaperC.question3();
       System.out.println("学生D的试卷------------");
       testPaperD.question1();
       testPaperD.question2();
       testPaperD.question3();
   }
}
