package com.jay.demo.thread;

/**
 * @Author JAY
 * @Date 2019/7/8 14:19
 * @Description 动态切换数据源
 **/
public class DynamicDataSourceEntity {

    private static final ThreadLocal<String> local = new ThreadLocal<>();

    /**
     * 清空数据源
     */
    public void clear() {
        local.remove();
    }

    /**
     * 获取当前正在使用的数据源名字
     *
     * @return String
     */
    public String get() {
        return local.get();
    }

    /**
     * 根据年份动态设置数据源
     * @param year
     */
    public void set(int year) {
        local.set("DB_" + year);
    }

}
