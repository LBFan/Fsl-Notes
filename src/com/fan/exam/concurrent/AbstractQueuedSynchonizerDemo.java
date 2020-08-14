package com.fan.exam.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyThreadAQS extends Thread {
    private Lock lock;

    public MyThreadAQS(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread() + " running");
        } finally {
            lock.unlock();
        }
    }
}

public class AbstractQueuedSynchonizerDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        MyThreadAQS t1 = new MyThreadAQS("t1", lock);
        MyThreadAQS t2 = new MyThreadAQS("t2", lock);
        t1.start();
        t2.start();
    }
}