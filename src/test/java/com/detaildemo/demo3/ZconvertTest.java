package com.detaildemo.demo3;

/**
 * author JayNing
 * created by 2020/1/14 17:24
 **/
public class ZconvertTest {



    public String convert(String s, int numRows) {

        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < chars.length; i++){
            if (i == numRows){

            }else {
                sb.append(chars[i]);
            }
        }

        return null;
    }

}
