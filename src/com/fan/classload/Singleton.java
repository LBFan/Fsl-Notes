package com.fan.classload;

/**
 * @author :  PF_23
 * @Description : 单例模式
 * @date : 2019/12/18.
 */

public class Singleton {
    private static Singleton singleton = new Singleton();
    public static int value1;
    public static int value2 = 0;

    private Singleton() {
        value1++;
        value2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }
}

