package com.jay.demo.design.template.no_use_template;

/**
 * @Author JAY
 * @Date 2018/11/9 10:38
 * @Description 考试测试【没有使用模板方法模式】
 **/
public class PaperTest {

    public static void main(String[] args) {
        System.out.println("学生A的答题----------");
        StudentA studentA = new StudentA();
        studentA.question1();
        studentA.question2();
        studentA.question3();
        System.out.println("学生B的答题----------");
        StudentB studentB = new StudentB();
        studentB.question1();
        studentB.question2();
        studentB.question3();
    }

}
