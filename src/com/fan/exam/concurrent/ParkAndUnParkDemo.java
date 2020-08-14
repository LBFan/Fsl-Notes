package com.fan.exam.concurrent;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description : locksupport demo
 * @Author : shulin.fan
 * @Date : 2020/8/11
 */

class MyThread extends Thread {
    private Object object;

    public MyThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println("before unpark");
        // 释放许可
        LockSupport.unpark((Thread) object);
        System.out.println("after unpark");
    }
}

public class ParkAndUnParkDemo {
    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01(Thread.currentThread());
        myThread01.start();
        try {
            // 主线程睡眠3s
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnParkDemo");
        System.out.println("after park");
    }
}
