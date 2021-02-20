package com.interview.core.callbyvalue;

/**
 * ClassName: Student
 * Description:
 * date: 2021/2/19 15:51
 *
 * @author ningjianjian
 */
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
