package com.fan.exam.concurrent;

import java.util.concurrent.locks.LockSupport;

class MyThread01 extends Thread {
    private Object object;

    public MyThread01(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        System.out.println("before interrupt");
        try {
            // 休眠3s
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = (Thread) object;
        // 中断线程
        thread.interrupt();
        System.out.println("after interrupt");
    }
}

public class InterruptDemo {
    public static void main(String[] args) {
        MyThread01 myThread = new MyThread01(Thread.currentThread());
        myThread.start();
        System.out.println("before park");
        // 获取许可
        LockSupport.park("ParkAndUnparkDemo");
        System.out.println("after park");
    }
}