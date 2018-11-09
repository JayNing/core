package com.jay.demo.design.template.use_template;

/**
 * @Author JAY
 * @Date 2018/11/9 10:41
 * @Description 考试试卷【使用了模板方法模式】
 **/
public class TestPaper {

    public void question1(){
        System.out.println("第一题，ABCD四个选型，选择" + answer1());
    }

    public String answer1(){return "";}

    public void question2(){
        System.out.println("第二题，ABCD四个选型，选择" + answer2());
    }

    public String answer2(){return "";}

    public void question3( ){
        System.out.println("第三题，ABCD四个选型，选择" + answer3());
    }

    public String answer3(){return "";}

}
