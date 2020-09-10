package com.fan.exam.singleton;

/**
 * @author :  PF_23
 * @Description : 单例模式
 * 静态内部类-线程安全
 * @date : 2020/04/02.
 */

public class Singleton05 {

    /**
     * 静态内部类
     */
    private static class SingletonHoleder {
        private static final Singleton05 INSTANCE = new Singleton05();
    }

    private Singleton05() {

    }

    /**
     * @return
     */
    public static Singleton05 getInstance() {
        return SingletonHoleder.INSTANCE;
    }
}

