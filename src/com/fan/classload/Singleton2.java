package com.fan.classload;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/12/18.
 */

public class Singleton2 {
    public static int value1;
    public static int value2 = 0;
    private static Singleton2 singleton = new Singleton2();

    private Singleton2(){
        value1++;
        value2++;
    }

    public static Singleton2 getInstance2(){
        return singleton;
    }
}

