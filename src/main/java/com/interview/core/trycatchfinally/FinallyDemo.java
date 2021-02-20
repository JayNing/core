package com.interview.core.trycatchfinally;

import org.junit.Test;

/**
 * ClassName: FinallyDemo
 * Description:
 *  当 try 语句和 finally 语句中都有 return 语句时，在方法返回之前，finally 语句的内容将被执行，并且 finally 语句的返回值将会覆盖原始的返回值。
 * date: 2021/2/19 17:02
 *
 * @author ningjianjian
 */
public class FinallyDemo {


    @Test
    public void test(){
        System.out.println(f(2));
    }

    /**
     * 当 try 语句和 finally 语句中都有 return 语句时，在方法返回之前，finally 语句的内容将被执行，并且 finally 语句的返回值将会覆盖原始的返回值。
     * @param value
     * @return
     */
    public int f(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
        //如果调用 f(2)，返回值将是 0，因为 finally 语句的返回值覆盖了 try 语句块的返回值。
    }
}
