package com.fan.singleton;

/**
 * @author :  PF_23
 * @Description : 单例模式
 * 静态内部类-线程安全
 * @date : 2020/04/02.
 */

public class Singleton05 {

    private static class SingletonHoleder {
        private static final Singleton05 INSTANCE = new Singleton05();
    }

    private Singleton05() {

    }

    /**
     * 加锁
     * 这会让线程阻塞时间过长，因此该方法有性能问题，不推荐使用
     *
     * @return
     */
    public static Singleton05 getInstance() {
        return SingletonHoleder.INSTANCE;
    }
}

