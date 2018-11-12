package com.jay.demo.design.observer.observer_;

/**
 * @Author JAY
 * @Date 2018/11/11 14:49
 * @Description 观察者模式Demo
 **/
public class ObserverDemo {

    public static void main(String[] args) {
        //首先人事经理通知大家第一件事
        HRSubject hrSubject = new HRSubject();
        //设置通知内容
        hrSubject.setNotifyInfo("出游时间是2018年11月30日");
        //通知三位同事
        hrSubject.addObserver(new ObserverA(hrSubject));
        hrSubject.addObserver(new ObserverB(hrSubject));
        hrSubject.addObserver(new ObserverC(hrSubject));
        //通知
        hrSubject.notifyNewInfo();
        System.out.println("-----------------------------------");
        //通知第二件事时，人事部门经理有事，请市场部经理代劳，市场经理通知大家第二件事
        MarketSubject marketSubject = new MarketSubject();
        marketSubject.setNotifyInfo("出游地点确定了，我们去浙江千岛湖...");
        marketSubject.addObserver(new ObserverA(marketSubject));
        marketSubject.addObserver(new ObserverC(marketSubject));

        //情况一、通知了员工B，但是那时候，B已离职，将员工B从观察者集合中移除。
        ObserverB observerB = new ObserverB(marketSubject);
        marketSubject.addObserver(observerB);
        marketSubject.removeObserver(observerB);

        //情况二、忘了通知员工B了
        marketSubject.notifyNewInfo();

        /**
         * 情况一和情况二，B都收不到通知
         */
    }

}
