package com.jay.demo.design.interpreter;

/**
 * @Author JAY
 * @Date 2018/11/25 16:04
 * @Description 解释器模式demo
 **/
public class InterpreterDemo {

    public static void main(String[] args) {
        Content content = new Content();
        content.setContent("东方,90°,5");
        Expression expression = null;
        String[] split = content.getContent().split(",");
        for (int i =0; i < 3; i++){
            switch (i){
                case 0:
                    expression = new FXExpression();
                    break;
                case 1:
                    expression = new JDExpression();
                    break;
                case 2:
                    expression = new BSExpression();
                    break;
            }
            expression.execute(split[i]);
        }
    }

}
