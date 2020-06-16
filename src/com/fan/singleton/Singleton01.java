package com.fan.singleton;

/**
 * @author :  PF_23
 * @Description : 单例模式
 * 懒汉式-线程不安全
 * @date : 2020/04/02.
 */

public class Singleton01 {

    private static Singleton01 instance;

    private Singleton01(){

    }

    public static Singleton01 getInstance() {
        if (instance == null) {
            instance = new Singleton01();
        }
        return instance;
    }
}

