package com.jay.demo.design.abstractfactory;

/**
 * @Author JAY
 * @Date 2018/11/11 16:37
 * @Description 消息工厂类
 **/
public class MessageFacatory {

    /**
     *  生产短信接口
     * @param type
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static ISMS createSMS(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /**
         * 使用反射技术来去除switch或if，解除分支判断带来的耦合
         */
        //根据类型，返回不同的短信方式
        if (type != null && !"".equals(type)){
            //拼接字符串，注意类名包含包名
            String className = "com.jay.demo.design.abstractfactory." + type +"Sms";
            //获取以className字符串为名的类
            Class<ISMS> ismsClass = (Class<ISMS>) Class.forName(className);
            return ismsClass.newInstance();
        }
        return null;
    }

    public static IEmail createEmail(String type) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        /**
         * 使用反射技术来去除switch或if，解除分支判断带来的耦合
         */
        //根据类型，返回不同的邮件方式
        if (type != null && !"".equals(type)){
            //拼接字符串，注意类名包含包名
            String className = "com.jay.demo.design.abstractfactory." + type +"Email";
            //获取以className字符串为名的类
            Class<IEmail> emailClass = (Class<IEmail>) Class.forName(className);
            return emailClass.newInstance();
        }
        return null;
    }
}
