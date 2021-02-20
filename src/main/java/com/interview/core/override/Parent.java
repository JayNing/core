package com.interview.core.override;

/**
 * ClassName: Parent
 * Description:
 * date: 2021/2/19 16:06
 *
 * @author ningjianjian
 */
public class Parent {

    public BigObj eat(){
        System.out.println("parent eat");
        return new BigObj();
    }

}
