package com.interview.core.override;

import org.apache.http.cookie.SM;

/**
 * ClassName: Children
 * Description:
 * date: 2021/2/19 16:07
 *
 * @author ningjianjian
 */
public class Children extends Parent{

    @Override
    public BigObj eat() {
        System.out.println("children eat");
        return new SmallObj();
    }
}
