package com.fan.exam.singleton;

/**
 * @author :  PF_23
 * @Description : 单例模式
 * 双重校验锁-线程安全
 * @date : 2020/04/02.
 */

public class Singleton04 {

    /**
     * 初始时不加载
     */
    private static volatile Singleton04 instance;

    private Singleton04() {
        System.out.println("我是构造方法 Singleton04()");
    }

    /**
     * 加锁
     * 这会让线程阻塞时间过长，因此该方法有性能问题，不推荐使用
     *
     * @return
     */
    public static Singleton04 getInstance() {
        if (instance == null) {
            synchronized (Singleton04.class) {
                if (instance == null) {
                    instance = new Singleton04();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                Singleton04.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}

