package com.jay.demo.design.observer.entrust;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author JAY
 * @Date 2018/11/11 15:23
 * @Description 事件管理类
 **/
public class EventHandler {

    private List<Event> objects;

    public EventHandler()
    {
        objects = new ArrayList<Event>();
    }

    public void addEvent(Object object, String methodName, Object...args)
    {
        objects.add(new Event(object, methodName, args));
    }

    public void notifyX() throws Exception
    {
        for (Event event : objects)
        {
            event.invoke();
        }
    }
}
