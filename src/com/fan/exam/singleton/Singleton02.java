package com.fan.exam.singleton;

/**
 * @author :  PF_23
 * @Description : 单例模式
 * 恶汉式-线程安全
 * @date : 2020/04/02.
 */

public class Singleton02 {

    /**
     * 初始时即加载
     */
    private static Singleton02 instance = new Singleton02();

    private Singleton02() {

    }

    public static Singleton02 getInstance() {
        if (instance == null) {
            instance = new Singleton02();
        }
        return instance;
    }
}

