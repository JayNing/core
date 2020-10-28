package com.jay.demo.design.decorator.subject;

/**
 * ClassName: SubjectTest
 * Description:
 * date: 2020/10/28 16:26
 *
 * @author ningjianjian
 */
public class SubjectTest {

    public static void main(String[] args) {
        AbstractSubject decator = null;

        decator = new SubjectBaseDecator(new BaseSubject());
        System.out.println(decator.getName());
        System.out.println(decator.getPrice());
        decator = new HomeworkSubjectDecator(decator);
        System.out.println(decator.getName());
        System.out.println(decator.getPrice());
        decator = new MessageSubjectDecator(decator);
        System.out.println(decator.getName());
        System.out.println(decator.getPrice());
        decator = new InterviewSubjectDecator(decator);
        System.out.println(decator.getName());
        System.out.println(decator.getPrice());
        decator = new InterviewSubjectDecator(decator);
        System.out.println(decator.getName());
        System.out.println(decator.getPrice());
        decator = new MessageSubjectDecator(decator);
        System.out.println(decator.getName());
        System.out.println(decator.getPrice());
    }

}
